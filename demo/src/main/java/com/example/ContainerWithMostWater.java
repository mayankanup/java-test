package com.example;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {

    class Test {
        int [] heights;
        int expected;
        public String toString(){
            return "Heights = " + Util.toString(heights) + " expected = " + expected;
        }
    }

    List<Test> setupTests() {
        List<Test> tests = new ArrayList<Test>();
        Test first = new Test();
        first.heights= new int [] {1,8,6,2,5,4,8,3,7};
        first.expected = 49;
        tests.add(first);

        Test second = new Test();
        second.heights = new int[] {1, 1};
        second.expected = 1;
        tests.add(second);

        return tests;
    }
    public void test(){
        List<Test> tests = setupTests();
        for(Test test : tests){
            int observed = maxArea(test.heights);
            String result = observed == test.expected ? "PASS" : "FAIL";
            System.out.println(result + " : " + test);
        }
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int area = (right - left) * Math.min(height[right], height[left]);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[right] > height[left]) {
                left +=1;
            } else {
                right -=1;
            }
        }
        return maxArea;
    }

}
