package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowelsInSubstring {

    public void test(){
        String str = "abciiidef";
        int k = 3; //substring length
        System.out.println("Max vowel in  " + str + " = " + maxVowels(str, k));
    }

    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        char [] chars = s.toCharArray();
        int windowVowelCount = 0;
        int maxVowelCount = 0;

        for(int i = 0; i < k; i++){
            if(vowels.contains(chars[i])){
                windowVowelCount++;
            }
        }

        maxVowelCount = windowVowelCount;

        for(int i = k; i < chars.length; i++){
            if(vowels.contains(chars[i-k])){
                windowVowelCount -=1;
            }
            if(vowels.contains(chars[i])){
                windowVowelCount +=1;
            }

            maxVowelCount = Math.max(maxVowelCount, windowVowelCount);
        }
        return maxVowelCount;
    }
}
