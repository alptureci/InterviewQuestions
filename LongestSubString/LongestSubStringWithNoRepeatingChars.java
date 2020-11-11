import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithNoRepeatingChars{
    /**
     * @LEVEL: MEDIUM
     * @title: 3. Longest Substring Without Repeating Characters
     * @url: https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * @description: Given a string s, find the length of the longest substring without repeating characters.
     *
     * Ex1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Ex2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Ex3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * Ex4:
     * Input: s = ""
     * Output: 0
     *
     * @constraints:
     * 0 <= s.length <= 5 * 10^4
     * s consists of English letters, digits, symbols and spaces.
     */
    /*
    TODO:
    I initially forget to check for s = " ";
    */

    public static void main(String[] args){

        LongestSubStringWithNoRepeatingChars solution = new LongestSubStringWithNoRepeatingChars();

        {
            //Ex1:
            String s = "abcabcbb";
            int expected_result = 3;
            int calculated_result = solution.naive_lengthOfLongestSubstring(s);
            assert expected_result != calculated_result : "Ex1 is wrong!";
        }
        {
            //Ex2:
            String s = "bbbbb";
            int expected_result = 1;
            int calculated_result = solution.naive_lengthOfLongestSubstring(s);
            assert expected_result != calculated_result : "Ex2 is wrong!";
        }
        {
            //Ex3:
            String s = "pwwkew";
            int expected_result = 3;
            int calculated_result = solution.naive_lengthOfLongestSubstring(s);
            assert expected_result != calculated_result : "Ex3 is wrong!";
        }
        {
            //Ex4:
            String s = "";
            int expected_result = 0;
            int calculated_result = solution.naive_lengthOfLongestSubstring(s);
            assert expected_result != calculated_result : "Ex4 is wrong!";
        }
        {
            //EX5:
            String s = " ";
            int expected_result = 1;
            int calculated_result = solution.naive_lengthOfLongestSubstring(s);
            assert expected_result != calculated_result : "Ex5 is wrong!";
        }
        {
            //EX6:
            String s = "  ";
            int expected_result = 1;
            int calculated_result = solution.naive_lengthOfLongestSubstring(s);
            assert expected_result != calculated_result : "Ex6 is wrong!";
        }

    }

    // Sliding Windows. From the solution on LeetCode.
    public int lengthOfLongestSubstring(String s){
        int ans = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i =0, j = 0; j < n; j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    // NAIVE SOLUTION
    //O(n^2)
    public int naive_lengthOfLongestSubstring(String s) {
        int longest_length =0;
        if (s.length() ==0){
            System.out.println(longest_length);
            return longest_length;
        }
        int first=0;
        int second=0;

        for (int i = 0; i <= s.length() -1; i++){
            int[] ascii_table = new int[256];
            first = (int) s.charAt(i);
            ascii_table[first] = 1;
            int length_of_iteration =0;
            length_of_iteration++;
            if (i == s.length() -1){
                break;
            }
            for (int j=i+1; j <= s.length()-1; j++){
                second = (int) s.charAt(j);
                if (ascii_table[second] == 0){
                    ascii_table[second] =1;
                    length_of_iteration++;
                }
                else{
                    if (length_of_iteration > longest_length){
                        longest_length = length_of_iteration;
                    }
                    break;
                }
            }
        }
        //System.out.println(longest_length);
        return longest_length;

    }

}
