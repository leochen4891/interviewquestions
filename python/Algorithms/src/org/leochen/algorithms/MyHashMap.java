package org.leochen.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {

	private List<List<Item>> store;
	private int capacity;

	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<>(3);

		map.put("a", 1);
		map.put("bb", 2);
		map.put("ccc", 3);
		map.put("dddd", 4);

		System.out.println(map.get("a"));
		System.out.println(map.get("bb"));
		System.out.println(map.get("ccc"));
		System.out.println(map.get("dddd"));
		System.out.println(map.get("eeeee"));
	}

	public MyHashMap(int capacity) {
		this.store = new ArrayList<List<Item>>();
		this.capacity = capacity;
		for (int i = 0; i < capacity; i++) {
			this.store.add(new LinkedList<Item>());
		}
	}

	public void put(K key, V value) {
		Item newItem = new Item(key, value);
		int index = key.hashCode() % capacity;
		List<Item> list = store.get(index);
		boolean updated = false;
		for (Item item : list) {
			if (item.key.equals(key)) {
				item.value = value;
				updated = true;
				break;
			}
		}
		if (!updated)
			list.add(newItem);
	}

	public V get(K key) {
		int index = key.hashCode();
		List<Item> list = store.get(index % capacity);
		for (Item item : list) {
			if (item.key.equals(key)) {
				return item.value;
			}
		}
		return null;
	}

	private class Item {
		public K key;
		public V value;

		public Item(K k, V v) {
			this.key = k;
			this.value = v;
		}
	}
}
