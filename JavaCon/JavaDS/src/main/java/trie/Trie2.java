/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 04/25/2016
 *
 * @author Tushar Roy
 * <p>
 * Insert/delete/search into trie data structure, O(keylen)
 * <p>
 * Reference
 * https://en.wikipedia.org/wiki/Trie
 */
public class Trie2 {

	private final TrieNode root;

	public Trie2() {
		root = new TrieNode();
	}

	// Driver
	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		List<String> keys = List.of("the", "a", "there", "answer", "any",
				"by", "bye", "their");

		String output[] = {"Not present in trie", "Present in trie"};

		Trie2 tr = new Trie2();

		// Construct trie
		keys.forEach(key -> tr.insert(key));

		// Search for different keys
		if (tr.search("the"))
			System.out.println("the --- " + output[1]);
		else System.out.println("the --- " + output[0]);

		if (tr.search("these"))
			System.out.println("these --- " + output[1]);
		else System.out.println("these --- " + output[0]);

		if (tr.search("their"))
			System.out.println("their --- " + output[1]);
		else System.out.println("their --- " + output[0]);

		if (tr.search("thaw"))
			System.out.println("thaw --- " + output[1]);
		else System.out.println("thaw --- " + output[0]);

	}

	/**
	 * Iterative implementation of insert into trie
	 */
	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}

			System.out.println(current);
			current = node;
		}
		//mark the current nodes endOfWord as true
		current.endOfWord = true;
	}

	/**
	 * Recursive implementation of insert into trie
	 */
	public void insertRecursive(String word) {
		insertRecursive(root, word, 0);
	}

	private void insertRecursive(TrieNode current, String word, int index) {
		if (index == word.length()) {
			//if end of word is reached then mark endOfWord as true on current node
			current.endOfWord = true;
			return;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);

		//if node does not exists in map then create one and put it into map
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}
		insertRecursive(node, word, index + 1);
	}

	/**
	 * Iterative implementation of search into trie.
	 */
	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			//if node does not exist for given char then return false
			if (node == null) {
				return false;
			}
			current = node;
		}
		//return true of current's endOfWord is true else return false.
		return current.endOfWord;
	}

	/**
	 * Recursive implementation of search into trie.
	 */
	public boolean searchRecursive(String word) {
		return searchRecursive(root, word, 0);
	}

	private boolean searchRecursive(TrieNode current, String word, int index) {
		if (index == word.length()) {
			//return true of current's endOfWord is true else return false.
			return current.endOfWord;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		//if node does not exist for given char then return false
		if (node == null) {
			return false;
		}
		return searchRecursive(node, word, index + 1);
	}

	/**
	 * Delete word from trie.
	 */
	public void delete(String word) {
		delete(root, word, 0);
	}

	/**
	 * Returns true if parent should delete the mapping
	 */
	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			//when end of word is reached only delete if currrent.endOfWord is true.
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			//if current has no other mapping then return true
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		//if true is returned then delete the mapping of character and trienode reference from map.
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			//return true if no mappings are left in the map.
			return current.children.size() == 0;
		}
		return false;
	}

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

		@Override
		public String toString() {
			return "{ " + children + " : " + endOfWord + "}";
		}
	}
}
