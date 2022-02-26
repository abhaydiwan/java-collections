Functional interfaces have changed the way data is compared in Java. This is due to the enhancements to the Comparator interface and the addition of several methods that utilize it in the Java API.

Section 10.1: The Comparator Interface
Comparator is a functional interface that is used to compare two objects. A Comparator is specified with type parameter T. Its functional method, called compare, takes two arguments of type T and returns an integer.
@FunctionalInterface
public interface Comparator<T>
{
    int compare(T o1, T o2);
    ...
}
T

The result of the compare method is as follows:
a positive integer: if o1 > o2
a negative integer: if o1 < o2
0:                  if o1 = o2


Comparators will most frequently be used to sort lists and streams.