package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return s1;
		}
		else if(s2.length() > s1.length()) {
			return s2;
		}
		else if(s1.length() == s2.length()){
			return s1;
		}
		return null;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		//System.out.println(s);
		String c = "";
		if(s.contains("underscores")) {
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == ' ') {
					c = s.replace(s.charAt(i), '_');
				}
			}
			//System.out.println(c);
			return c;
		}
		return s;		
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char s1char = 0;
		char s2char = 0;
		char s3char = 0;
		
		for (int i = s1.length()-1; i > 0; i--) {
			if(s1.charAt(i) != ' ') {
				s1char = s1.charAt(i);
				break;
			}
		}
		for (int j = s2.length()-1; j > 0; j--) {
			if(s2.charAt(j) != ' ') {
				s2char = s2.charAt(j);
				break;
			}
		}
		for (int x = s3.length()-1; x > 0; x--) {
			if(s3.charAt(x) != ' ') {
				s3char = s3.charAt(x);
				break;
			}
		}
		//picks last character
		
		String s1letter = "";
		s1letter += s1char;
		String s2letter = "";
		s2letter += s2char;
		String s3letter = "";
		s3letter += s3char;
		
		
		String lineleader = "";
		if(s1letter.compareToIgnoreCase(s2letter) < 0) { //s1 smaller than s2
			if(s1letter.compareToIgnoreCase(s3letter) < 0){ //s1 smaller than s3
				lineleader = s1letter;
			}
			else if(s1letter.compareToIgnoreCase(s3letter) > 0) { //s3 smaller than s1
				lineleader = s3letter;
			}
		}
		else if(s1letter.compareToIgnoreCase(s2letter) > 0) { //s2 smaller than s1
			if(s2letter.compareToIgnoreCase(s3letter) < 0) {
				lineleader = s2letter;
			}
			else if(s2letter.compareToIgnoreCase(s3letter) > 0) {
				lineleader = s3letter;
			}
		}
		
		//organizes alphabetically
		//System.out.println(s1letter + ", " + s2letter + ", " + s3letter);
		//System.out.println(lineleader);
		
		int firstletterindex = 0;
		int lastletterindex = 0;
		String news1 = "";
		int firstletterindexs2 = 0;
		int lastletterindexs2 = 0;
		String news2 = "";
		int firstletterindexs3 = 0;
		int lastletterindexs3 = 0;
		String news3 = "";
		
		//remove spaces
		if(lineleader == s1letter) {
			for (int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != ' ') {
					firstletterindex = i;
					break;
				}
			}
			for (int i = s1.length()-1; i > 0; i--) {
				if(s1.charAt(i) != ' ') {
					lastletterindex = i;
					break;
				}
			}
			for (int i = firstletterindex; i < lastletterindex+1; i++) {
				news1 += s1.charAt(i);
			}
			return news1;
		}
		else if(lineleader == s2letter) {
			for (int i = 0; i < s2.length(); i++) {
				if(s2.charAt(i) != ' ') {
					firstletterindexs2 = i;
					break;
				}
			}
			for (int i = s2.length()-1; i > 0; i--) {
				if(s2.charAt(i) != ' ') {
					lastletterindexs2 = i;
					break;
				}
			}
			for (int i = firstletterindexs2; i < lastletterindexs2+1; i++) {
				news2 += s2.charAt(i);
			}
			return news2;
		}
		else {
			for (int i = 0; i < s3.length(); i++) {
				if(s3.charAt(i) != ' ') {
					firstletterindexs3 = i;
					break;
				}
			}
			for (int i = s3.length()-1; i > 0; i--) {
				if(s3.charAt(i) != ' ') {
					lastletterindexs3 = i;
					break;
				}
			}
			for (int i = firstletterindexs3; i < lastletterindexs3+1; i++) {
				news3 += s3.charAt(i);
			}
			return news3;
		}
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		char currentnum;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9') {
				currentnum = s.charAt(i);
				sum += Character.getNumericValue(currentnum);
			}
		}
		//System.out.println(sum);
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		//int substringlength = substring.length();
		int num = 0;
		int onecharnum = 0;
		Boolean char1exists = false;
		Boolean char2exists = false;
		int fullstring = 0;
		if(s.contains(substring)){
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == substring.charAt(0) && substring.length() < 2) {
					onecharnum += 1;
				}
			}
			for (int i = 0; i < s.length(); i ++) {
				if(s.charAt(i) == substring.charAt(0) && substring.length() > 1) {
					char1exists = true;
					if(s.charAt(i+1) == substring.charAt(1)) {
						char2exists = true;
						if(s.charAt(i+2) == substring.charAt(2)) {
							fullstring += 1;
						}
					}
				}
			}
			num = fullstring;
			
			//System.out.println(substring.charAt(0) + ", " + substring.length() + ", " + num);
			if(substring.length() < 2) {
				return onecharnum;
			}
			else {
				return num;
			}
		}
		else {
			num = 0;
			return num;
		}
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte) key);           
		
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte) key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int count = 0;
		int spaceindex = 0;
		int startindex = -1;
		String split = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				spaceindex = i;
				for (int j = startindex+1; j < spaceindex; j++) {
					split += s.charAt(j);
					startindex = spaceindex;
				}
				if(split.endsWith(substring)) {
					count += 1;
				}
			}	
		}
		//System.out.println(count);
		return count;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int firstind = s.indexOf(substring);
		int lastind = s.lastIndexOf(substring);
		int firstindnew = firstind + (substring.length());
		int spaces = lastind-firstindnew;
		
		return spaces;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String forward = "";
		String backward = "";
		for (int i = 0; i < s.length(); i++) {
			if(Character.isLetterOrDigit(s.charAt(i)) == true) {
				forward += s.charAt(i);
			}
		}
		for (int i = s.length()-1; i > -1; i--) {
			if(Character.isLetterOrDigit(s.charAt(i)) == true) {
				backward += s.charAt(i);
			}
		}
		String forwardUpper = forward.toUpperCase();
		String backwardUpper = backward.toUpperCase();

		if(forwardUpper.equals(backwardUpper)) {
			//System.out.println("yes");
			return true;
		}
		else {
			//System.out.println("no");
			return false;
		}
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
