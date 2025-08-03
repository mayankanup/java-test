package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffArrays {

    public void test(){
        int [] nums1 = {1,2,3,3};
        int [] nums2 = {1,1,2,2};
        System.out.println("[[3], []]".equals(findDifference(nums1, nums2).toString()));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<Integer> numSet= new HashSet<Integer>();

        //ProcessFirst Array
        for(int i=0; i< nums1.length; i++ ){
            numSet.add(nums1[i]);
        }

        for(int i=0; i< nums2.length; i++ ){
            numSet.remove(nums2[i]);
        }
        
        results.add(new ArrayList<Integer>(numSet));

        //Process second Array
        numSet= new HashSet<Integer>();
        for(int i=0; i< nums2.length; i++ ){
            numSet.add(nums2[i]);
        }

        for(int i=0; i< nums1.length; i++ ){
            numSet.remove(nums1[i]);
        }
        
        results.add(new ArrayList<Integer>(numSet));

        return results;
    }
}
