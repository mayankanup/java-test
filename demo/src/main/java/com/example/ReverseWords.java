package com.example;

import java.util.HashMap;
import java.util.Map;

public class ReverseWords {
    public void test(){
        Map<String, String> answerKeys = new HashMap<String, String>();
        answerKeys.put("the sky is blue", "blue is sky the");
        answerKeys.put("  hello world  ","world hello");
        answerKeys.put("a good   example", "example good a");
        for(String s : answerKeys.keySet()) {
            System.out.println(s + " --> " + (reverseWords(s).equals(answerKeys.get(s))? "PASS" : "FAIL"));
        }
    }

    public String reverseWords(String s) {
       if (s == null || s.length()==0) return s;
       String [] words = s.split("\\s+");
       StringBuilder sb = new StringBuilder();
       for(int i=words.length-1; i>=0; i--){
        if(words[i].length()>0){
            sb.append(words[i]);
            if(i>0){
                sb.append(" ");
            }
        }
       }
       return sb.toString().trim();
    }
}
