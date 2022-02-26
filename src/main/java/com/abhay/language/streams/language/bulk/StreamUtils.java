package com.abhay.language.streams.language.bulk;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
//https://stackoverflow.com/questions/30641383/java-8-stream-with-batch-processing
public class StreamUtils {

    /**
     * Creates a new batch collector
     * @param batchSize the batch size after which the batchProcessor should be called
     * @param batchProcessor the batch processor which accepts batches of records to process
     * @param <T> the type of elements being processed
     * @return a batch collector instance
     */
    public static <T> Collector<T, List<T>, List<T>> batchCollector(int batchSize, Consumer<List<T>> batchProcessor) {
        return new BatchCollector<T>(batchSize, batchProcessor);
    }
    
    public static void main(String[] args) {
		
    	List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    	List<Integer> output = new ArrayList<>();
    	int batchSize = 3;
    	Consumer<List<Integer>> batchProcessor = xs -> output.addAll(xs);
    	input.stream().collect(StreamUtils.batchCollector(batchSize, batchProcessor));
    	
    	BatchingIterator.batchedStreamOf(Stream.of("A","E","C","D","B","F"), 3)
        .forEach(System.out::println);
	}
}

/**
 * Collects elements in the stream and calls the supplied batch processor
 * after the configured batch size is reached.
 *
 * In case of a parallel stream, the batch processor may be called with
 * elements less than the batch size.
 *
 * The elements are not kept in memory, and the final result will be an
 * empty list.
 *
 * @param <T> Type of the elements being collected
 */
class BatchCollector<T> implements Collector<T, List<T>, List<T>> {

    private final int batchSize;
    private final Consumer<List<T>> batchProcessor;


    /**
     * Constructs the batch collector
     *
     * @param batchSize the batch size after which the batchProcessor should be called
     * @param batchProcessor the batch processor which accepts batches of records to process
     */
    BatchCollector(int batchSize, Consumer<List<T>> batchProcessor) {
        batchProcessor = requireNonNull(batchProcessor);

        this.batchSize = batchSize;
        this.batchProcessor = batchProcessor;
    }

    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    public BiConsumer<List<T>, T> accumulator() {
        return (ts, t) -> {
            ts.add(t);
            if (ts.size() >= batchSize) {
                batchProcessor.accept(ts);
                ts.clear();
            }
        };
    }

    public BinaryOperator<List<T>> combiner() {
        return (ts, ots) -> {
            // process each parallel list without checking for batch size
            // avoids adding all elements of one to another
            // can be modified if a strict batching mode is required
            batchProcessor.accept(ts);
            batchProcessor.accept(ots);
            return Collections.emptyList();
        };
    }

    public Function<List<T>, List<T>> finisher() {
        return ts -> {
            batchProcessor.accept(ts);
            return Collections.emptyList();
        };
    }

    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}

class BatchingIterator<T> implements Iterator<List<T>> {
    private static final int ORDERED = 0;

	/**
     * Given a stream, convert it to a stream of batches no greater than the
     * batchSize.
     * @param originalStream to convert
     * @param batchSize maximum size of a batch
     * @param <T> type of items in the stream
     * @return a stream of batches taken sequentially from the original stream
     */
    public static <T> Stream<List<T>> batchedStreamOf(Stream<T> originalStream, int batchSize) {
        return asStream(new BatchingIterator<>(originalStream.iterator(), batchSize));
    }

    private static <T> Stream<T> asStream(Iterator<T> iterator) {
        return StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(iterator,ORDERED),
            false);
    }

    private int batchSize;
    private List<T> currentBatch;
    private Iterator<T> sourceIterator;

    public BatchingIterator(Iterator<T> sourceIterator, int batchSize) {
        this.batchSize = batchSize;
        this.sourceIterator = sourceIterator;
    }

    @Override
    public boolean hasNext() {
        prepareNextBatch();
        return currentBatch!=null && !currentBatch.isEmpty();
    }

    @Override
    public List<T> next() {
        return currentBatch;
    }

    private void prepareNextBatch() {
        currentBatch = new ArrayList<>(batchSize);
        while (sourceIterator.hasNext() && currentBatch.size() < batchSize) {
            currentBatch.add(sourceIterator.next());
        }
    }
}