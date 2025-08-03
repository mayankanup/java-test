package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveStarsFromString {

    class Test {
        String input;
        String expected;
        public String toString(){
            return "Input = " + input + " expected = " + expected;
        }
    }

    List<Test> setupTests() {
        List<Test> tests = new ArrayList<Test>();
        Test first = new Test();
        first.input= "leet**cod*e";
        first.expected = "lecoe";
        tests.add(first);

        Test second = new Test();
        second.input = "erase*****";
        second.expected = "";
        tests.add(second);

        return tests;
    }
    public void test(){
        List<Test> tests = setupTests();
        for(Test test : tests){
            String observed = removeStars(test.input);
            String result = observed.equals(test.expected) ? "PASS" : "FAIL";
            System.out.println(result + " : " + test);
        }
    }

    /*
     * Choose a star in s.
     * Remove the closest non-star character to its left, as well as remove the star itself.
     */
    public String removeStars(String s) {
        Stack<Character> charStack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='*' && charStack.size()> 0){
                charStack.pop();
            }
            if (ch!='*'){
                charStack.push(ch);
            }
        }

        char [] cleanup = new char[charStack.size()];
        int index = cleanup.length - 1;
        while(charStack.size()>0){
            cleanup[index] = charStack.pop();
            index -=1;
        }
        return new String(cleanup);
    }

}
