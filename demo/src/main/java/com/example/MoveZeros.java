package com.example;

public class MoveZeros {

    public void test() {
        int [] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Util.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1) return;
        int left = 0; int right = 1;
        while(left < nums.length - 1){
            if(nums[left] == 0){
                for (int j= left + 1; j < nums.length; j++ ){
                    if(nums[j] != 0){
                        right = j;
                        break;
                    }
                }
                nums[left] = nums[right];
                nums[right] = 0;
            }
            left +=1;
        }
    }

}
