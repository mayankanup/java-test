package com.example;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public void test(){
        int [] nums;
        int k=0;
        
        //First test case
        nums= new int []{3,2,1,5,6,4};
        k=2;
        System.out.println(" k = " + k + " largest in "+Util.toString(nums) + " : "+findKthLargest(nums, k));

        //Second test case
        nums = new int [] {3,2,3,1,2,4,5,5,6};
        k=4;
        System.out.println(" k = " + k + " largest in "+Util.toString(nums) + " : "+findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            if(priorityQueue.size()>= k){
                int smallest = priorityQueue.peek();
                if(nums[i] > smallest){
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            } else {
                priorityQueue.offer(nums[i]);
            }
        }
        System.out.println("Priority queue "+ priorityQueue.toString());
        return priorityQueue.poll();
    }
}
