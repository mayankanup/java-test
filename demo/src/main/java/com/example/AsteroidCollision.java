package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {

    class Test {
        int [] input;
        int [] expected;
        Test() {}
        Test(int [] input, int [] expected){
            this.input = input;
            this.expected = expected;
        }
        public String toString(){
            return "Input = " + Util.toString(input) + " expected = " + Util.toString(expected);
        }
    }

    List<Test> setupTests() {
        List<Test> tests = new ArrayList<Test>();
        Test test = new Test(new int [] {5,10,-5}, new int[] {5,10});
        tests.add(test);

        test = new Test(new int [] {8, -8}, new int [] {});
        tests.add(test);

        test = new Test(new int [] {10, 2, -5}, new int [] {10});
        tests.add(test);

        return tests;
    }
    public void test(){
        List<Test> tests = setupTests();
        for(Test test : tests){
            int [] observed = asteroidCollision(test.input);
            String result = Arrays.equals(test.expected, observed) ? "PASS" : "FAIL";
            System.out.println(result + " : " + test);
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length <= 1) return asteroids;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<asteroids.length; i++){
            int a = asteroids[i];
            if(asteroids[i] > 0){
                stack.push(a);
            } else {
                while(stack.size()> 0 && stack.peek() > 0 && stack.peek() < -a){
                    stack.pop();
                }
                if(stack.size()>0 && stack.peek()==-a){
                    stack.pop();
                } else if(stack.size()==0 || stack.peek() < 0){
                    stack.push(a);
                }
            }
        }

        if(stack.size()==0) return new int[] {};

        int [] results = new int [stack.size()];
        int index = results.length - 1;
        while(stack.size()>0){
            results[index] = stack.pop();
            index -=1;
        }
            
        return results;
    }
}
