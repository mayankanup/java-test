package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberToLetterCombinations {

    public void test(){
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations(""));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length()==0) return result;
        Map<Character, String> digitMap = new HashMap<Character, String>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");

        StringBuilder combination = new StringBuilder();
        int index = 0;
        backtrack(digits, index, digitMap, result, combination);
        return result;
    }

    private void backtrack(String digits, int index, Map<Character, String> digitMap, List<String> result, StringBuilder combination){
        if(index == digits.length()){
            result.add(combination.toString());
            return;
        }
        char ch = digits.charAt(index);
        String keyLetters = digitMap.get(ch);
        if(keyLetters == null){
            System.out.println("Invalid digit found : " + ch);
        }
        for(int i=0; i<keyLetters.length(); i++){
            char letter = keyLetters.charAt(i);
            combination.append(letter);
            backtrack(digits, index + 1, digitMap, result, combination);
            combination.deleteCharAt(combination.length()-1);
        }
    }
}
