package WordLadder;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

import utilities.*;

public class WordLadder {
	
	private Queue<String> queue = new LinkedList<String>();
	//private String[] dictionary;
	private ArrayList<String> checked_words = new ArrayList<String>();
	private String[] sorted_checked_words;
	
	public boolean wordLadder(String src, String target, String[] sorted_dictionary){
		if (src.length() != target.length()) {
			System.out.println("src and target sources should be same");
		}
		
		queue.add(src);
		checked_words.add(src);
		
		while (!queue.isEmpty()){
			
			if (queue.peek().equals(target)) return true;
			
			char[] word = queue.poll().toCharArray();
			String tmp_word = new String(word);
			
			// duplicate
			// I have to find a way to insert in order. Currently it inserts and sorts all of it again and again.
			if (checked_words != null && checked_words.size() != 0){
				/*sorted_checked_words = checked_words.toArray(sorted_checked_words);
				Arrays.sort(sorted_checked_words);*/
			}
			
			
			
			for (int i = 0; i < word.length; i++){
				
				word = tmp_word.toCharArray();
				
				for (char c = 'a'; c <= 'z'; c++){
					

					sorted_checked_words = new String[checked_words.size()];
					sorted_checked_words = checked_words.toArray(sorted_checked_words);
					Arrays.sort(sorted_checked_words);
					
					word[i] = c;
					
					String test_word = new String(word);
					
					if (test_word.equals(target)){
						return true;
					}
					
					// Will be improved using real world dictionary api. 
					// if NOT in dictionary &&
					// if NOT in previously searched word
					// add to queue
					// add to checked_words;
					if (BinarySearch4ArrayOfStrings.binarySearch(sorted_dictionary, test_word)){
							if (sorted_checked_words != null && 
									sorted_checked_words.length != 0 && 
									!BinarySearch4ArrayOfStrings.binarySearch(sorted_checked_words, test_word)){
								
								// This is just for my personal test
								// It tests whether it is inserting right elements into the checked_words
								// System.out.print(test_word + "-");
								queue.add(test_word);
								checked_words.add(test_word);
							}
					}
					
					
										
				}
			}			
		}
			return false;
	}
	
	
	public static void test(){
		WordLadder wl = new WordLadder();
		String[] dictionary = {"cat", "bat", "bet", "bit", "but", "bad", "bed", "bid", 
								"sit","set",  "sad"};
		Arrays.sort(dictionary);
		String src = "cat";
		String target = "set";
		System.out.println("\n"+wl.wordLadder(src, target, dictionary));
	}
	
	public static void main(String[] args){
		test();
	}

}
