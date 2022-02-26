package com.abhay.language.cache;

import java.util.*;

//it has k, va, next,prev

class Node {
	int key, val;
	Node next, prev;

	public Node(int k, int v) {
		this.key = k;
		this.val = v;
	}
}

// it has capacity, hashmap, count, head and tail
class LRUCache {
	int capacity, count;
	Map<Integer, Node> cache;
	Node head, tail;

	public LRUCache(int capacity) {
		cache = new HashMap<>();
		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		this.head.next = tail;
		this.head.prev = null;
		this.tail.prev = head;
		this.tail.next = null;
	}

	public void deleteNode(Node n) {
		n.next.prev = n.prev;
		n.prev.next = n.next;
	}

	public void addNodeToHead(Node n) {
		n.next = head.next;
		n.prev = head;
		n.next.prev = n;
		head.next = n;
	}

	public int get(int key) {

		if (cache.get(key) != null) {

			Node n = cache.get(key);
			int result = n.val;
			deleteNode(n);
			addNodeToHead(n);

			return result;
		}
		return -1;
	}

	public void set(int key, int value) {

		if (cache.get(key) != null) {

			Node n = cache.get(key);
			int result = n.val;
			deleteNode(n);
			addNodeToHead(n);
		} else {

			Node n = new Node(key, value);
			if (count < capacity) {

				addNodeToHead(n);
				count++;
			} else {

				addNodeToHead(n);
				deleteNode(tail.prev);
				count++;
				// delete tail.prev
			}
		}
	}

}

public class LRUCacheEx {

}
