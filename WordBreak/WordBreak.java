package WordBreak;

import java.util.*;

public class WordBreak{

    public boolean wordBreak(String s, List<String> wordDict) {

        //String tempString = s;
        boolean result = false;

        for (String word : wordDict){
            result = s.contains(word);
        }


        return result;
    }

    public static void main(String[] args){

        WordBreak wordBreak = new WordBreak();
        wordBreak.example1();


    }

    public void example1(){
        String s =  "leetcode";
        String[] word_dict_array = {"leet", "code"};
        List<String> wordDict = Arrays.asList(word_dict_array);

        System.out.println(wordBreak(s, wordDict));
    }
    
}
