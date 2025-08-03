package com.example;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnes {

    class Test {
        int [] nums;
        int k;
        int expected;
    }

    List<Test> setupTests() {
        List<Test> tests = new ArrayList<Test>();
        Test first = new Test();
        first.nums = new int [] {1,1,1,0,0,0,1,1,1,1,0};
        first.k = 2;
        first.expected = 6;
        tests.add(first);

        Test second = new Test();
        second.nums = new int [] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        second.k = 3;
        second.expected = 10;
        tests.add(second);
        return tests;
    }
    public void test(){
        List<Test> tests = setupTests();
        for(Test test : tests){
            int observed = longestOnes(test.nums, test.k);
            String result = observed == test.expected ? "PASS" : "FAIL";
            System.out.println(result + " : " + Util.toString(test.nums)+ 
                " K = " + test.k + " expected = " + test.expected + " observed = " + observed);
        }
    }

    public int longestOnes(int[] nums, int k) {
        int right=0, left=0, numzeros=0, length=0, maxlength = 0;
        while (right < nums.length){
            if(nums[right] ==0 ){
                numzeros +=1;
            }
            if(numzeros > k) {
                if(nums[left] == 0){
                    numzeros -=1;
                }
                left +=1;
            }
            if (numzeros <= k){
                length = right - left + 1;
                maxlength = Math.max(length, maxlength);
            }
            right +=1;
        }
        return maxlength;
    }
}
