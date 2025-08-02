package com.example;

public class Util {
    public static String toString(int [] nums){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i=0; i< nums.length; i++){
            sb.append(nums[i]);
            if(i< (nums.length -1) ) {
                sb.append(", ");
            } else {
                sb.append("}");
            }
        }
        return sb.toString();
    }

    public static String toString(char [] chars){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i=0; i< chars.length; i++){
            sb.append(chars[i]);
            if(i< (chars.length -1) ) {
                sb.append(", ");
            } else {
                sb.append("}");
            }
        }
        return sb.toString();
    }
}
