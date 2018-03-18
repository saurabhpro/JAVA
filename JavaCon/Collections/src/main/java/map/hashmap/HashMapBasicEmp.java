/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Saurabh on 10/5/2015.
 */


public class HashMapBasicEmp {

	public static void main(String[] args) {
		HashMap<BasicEmp, String> hashMap = new HashMap<>();

		System.out.println("initial size: " + hashMap.size());

		hashMap.put(new BasicEmp(10), "xxx");
		hashMap.put(new BasicEmp(10), "aaaa");
		hashMap.put(new BasicEmp(10), "aaaa");
		hashMap.put(new BasicEmp(10), "xyxx");

		System.out.println("Size after inserting 4 values with same key: " + hashMap.size());

		Set set = hashMap.entrySet();
		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry e = (Map.Entry) iterator.next();
			BasicEmp k = (BasicEmp) e.getKey();
			System.out.println(k.id + " " + e.getValue());
		}

		System.out.println("Adding new elements");
		hashMap.put(new BasicEmp(20), "bbbb");
		hashMap.put(new BasicEmp(30), "cccc");
		hashMap.put(new BasicEmp(40), "dddd");

		set = hashMap.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry e = (Map.Entry) iterator.next();
			BasicEmp k = (BasicEmp) e.getKey();
			System.out.println(k.id + " " + e.getValue());
		}

		BasicEmp e = new BasicEmp(40);
		String ss = hashMap.get(e);
		System.out.println("Value returned for key 40: " + ss);

		hashMap.remove(e);

		set = hashMap.entrySet();
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry e1 = (Map.Entry) iterator.next();
			BasicEmp k = (BasicEmp) e1.getKey();
			System.out.println(k.id + " " + e1.getValue());
		}

		hashMap.clear();
		System.out.println("Size after clear: " + hashMap.size());
	}

	static class BasicEmp {
		private final int id;

		BasicEmp(int id) {
			this.id = id;
		}

		@Override
		public boolean equals(Object obj) {
			BasicEmp e = (BasicEmp) obj;
			return this.id == e.id;
		}

		@Override
		public int hashCode() {
			return id * 10;
		}
	}
}
