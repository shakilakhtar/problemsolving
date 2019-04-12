/**
 * 
 */
package com.ds.arrayandstring;

/**
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author akhsh01
 *
 */
public class StringsAnagrams {

	//There are two easy ways to solve this problem:
	
	//Solution #1: Sort the strings
	 boolean anagram1(String s, String t) {
		 throw new UnsupportedOperationException();
	   //return sort(s) == sort(t);
	 }
	 
	 //Solution #2: Check if the two strings have identical counts for each unique char.
	public static boolean anagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it�s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}
}
