/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package map.hashmap.api;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.util.Objects.hash;


public class MyLinkedHashMap implements Map{
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public String get(Object key) {
		Node e;
		return (e = getNode(hash(key), key)) == null ? null : e.value;
	}

	private Node getNode(int hash, Object key) {
		return newNode(222,12,"Hi", null);
	}

	@Override
	public String put(Object key, Object value) {
		return putVal(hash(key), key, value, false, true);
	}

	private String putVal(int hash, Object key, Object value, boolean b, boolean b1) {
		return null;
	}

	@Override
	public Object remove(Object key) {
		return null;
	}

	@Override
	public void putAll(@NotNull Map m) {

	}

	@Override
	public void clear() {

	}

	@NotNull
	@Override
	public Set keySet() {
		return null;
	}

	@NotNull
	@Override
	public Collection values() {
		return null;
	}

	@NotNull
	@Override
	public Set<Map.Entry> entrySet() {
		return null;
	}

	static class Node {
		final int hash;
		final int key;
		String value;
		Node next;

		Node(int hash, int key, String value, Node next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final int getKey()        { return key; }
		public final String getValue()      { return value; }
		public final String toString() { return key + "=" + value; }

		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		public final String setValue(String newValue) {
			String oldValue = value;
			value = newValue;

			return oldValue;
		}

		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Map.Entry) {
				Map.Entry<?,?> e = (Map.Entry<?,?>)o;
				if (Objects.equals(key, e.getKey()) &&
						Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}
	}

	static class Entry extends Node{
		Entry before, after;

		public Entry(int hash, int key, String value, Node next) {
			super(hash, key, value, next);
		}
	}

	/**
	 * The head (eldest) of the doubly linked list.
	 */
	transient Entry head;

	/**
	 * The tail (youngest) of the doubly linked list.
	 */
	transient Entry tail;

	void reinitialize() {
		head = tail = null;
	}

	// link at the end of list
	private void linkNodeLast(Entry p) {
		Entry last = tail;
		tail = p;

		if (last == null)
			head = p;
		else {
			p.before = last;
			last.after = p;
		}
	}

	Node newNode(int hash, int key, String value, Node e) {
		Entry p =
				new Entry(hash, key, value, e);
		linkNodeLast(p);
		return p;
	}
}