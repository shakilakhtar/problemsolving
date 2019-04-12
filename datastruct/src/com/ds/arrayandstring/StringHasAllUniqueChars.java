/**
 * 
 */
package com.ds.arrayandstring;

/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures.
 * 
 * @author akhsh01
 *
 */
public class StringHasAllUniqueChars {
	
	public static void main(String[] args) {
		String str = "Helio";
		System.out.println("String is having unique chars is : "+isUniqueChars2(str));
	}

	static boolean  checkAniqueChars(String inputString){
		boolean success=false;
		char temp;
		for(int i=0;i<inputString.length();i++){
			temp = inputString.charAt(i);
			for(int j=0;j<inputString.length();j++){
				
			}
		}
		return success;
	}
	
	//Assume char set is ASCII(If not then increase the storage size)
	//Time complexity is O(n), where n is the length of the string, and space complexity is O(n).
	public static boolean isUniqueChars2(String str) {
		boolean[] charSet = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val])
				return false;
			charSet[val] = true;
		}
		return true;
	}
	
//	Alternatively, we could do the following:
//		1. Check every char of the string with every other char of the string for duplicate occurrences. 
//		This will take O(n^2) time and no space.
//		2. If we are allowed to destroy the input string, we could sort the string in O(n log n) time 
//		and then linearly check the string for neighboring characters that are identical. Careful, 
//		though - many sorting algorithms take up extra space.
}
