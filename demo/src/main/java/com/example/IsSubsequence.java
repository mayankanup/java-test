package com.example;

import java.util.ArrayList;
import java.util.List;

public class IsSubsequence {

    class Test {
        String s;
        String t;
        boolean expected;
        public String toString(){
            return "s = " + s + " t = " + t + " expected = " + expected;
        }
    }

    List<Test> setupTests() {
        List<Test> tests = new ArrayList<Test>();
        Test first = new Test();
        first.s="abc";
        first.t = "ahbgdc";
        first.expected = true;
        tests.add(first);

        Test second = new Test();
        second.s = "axc";
        second.t = "ahbgdc";
        second.expected = false;
        tests.add(second);

        Test third = new Test();
        third.s = "b";
        third.t = "abc";
        third.expected = true;
        tests.add(third);

        return tests;
    }
    public void test(){
        List<Test> tests = setupTests();
        for(Test test : tests){
            boolean observed = isSubsequence(test.s, test.t);
            String result = observed == test.expected ? "PASS" : "FAIL";
            System.out.println(result + " : " + test);
        }
    }

    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int first = 0; int second = 0;
        while ( first< s.length() && second < t.length() ){
            if( s.charAt(first) == t.charAt(second)) {
                first +=1;
            }
            second +=1;
        }
        return first == s.length();
    }

}
