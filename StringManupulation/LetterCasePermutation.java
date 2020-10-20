package StringManupulation;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 784 Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */


public class LetterCasePermutation {

    public List<String> letterCasePermutation(final String S) {

        List<String> letterCasePermuatationList = new ArrayList<String>();

        // do validity checks
        if (S.length() < 0){
            return null;
        }

        //do permuatation
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
        }


        return letterCasePermuatationList;

    }

}
