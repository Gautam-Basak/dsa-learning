package LinkedList.Doubly;

import java.util.HashMap;

class LRUNode {

	int key, value;
	LRUNode next;
	LRUNode pre;

	public LRUNode(int key, int value) {

		this.key = key;
		this.value = value;
	}
}

public class LRUcache {

	LRUNode head, tail;
	int capacity;
	HashMap<Integer, LRUNode> map;

	public LRUcache(int cap) {

		this.capacity = cap;
		map = new HashMap<>();
		head = new LRUNode(0, 0);
		tail = new LRUNode(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
	}

	public int get(int key) {

		if (map.containsKey(key)) {
			LRUNode keyNode = map.get(key);
			remove(keyNode);
			insert(keyNode);
			return keyNode.value;

		} else {
			return -1;
		}
	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			LRUNode keyNode = map.get(key);
			remove(keyNode);
		}

		if (map.size() == capacity) {
			remove(tail.pre);
		}
		insert(new LRUNode(key, value));
	}

	private void insert(LRUNode keyNode) {
		map.put(keyNode.key, keyNode);

		keyNode.next = head.next;
		keyNode.next.pre = keyNode;
		keyNode.pre = head;
		head.next = keyNode;

	}

	private void remove(LRUNode keyNode) {
		map.remove(keyNode.key);

		keyNode.pre.next = keyNode.next;
		keyNode.next.pre = keyNode.pre;
	}

	public static void main(String[] args) {

		LRUcache cache = new LRUcache(2);

		// it will store a key (1) with value
		// 10 in the cache.
		cache.put(1, 10);

		// it will store a key (2) with value 20 in the cache.
		cache.put(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

		cache.put(3, 30);

		System.out.println("Value for the key: 1 is " + cache.get(2));

		cache.put(4, 40);

		System.out.println("Value for the key: 1 is " + cache.get(1));

		System.out.println("Value for the key: 3 is " + cache.get(3));
		
		System.out.println("Value for the key: 4 is " + cache.get(4));

	}

}
