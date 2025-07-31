package com.example;

import java.util.Arrays;

public class EraseOverlappingIntervals {
    
    public void test(){
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    private int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int nonOverlappingEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < nonOverlappingEnd){
                //This interval need to be removed
                res++;
            } else {
                nonOverlappingEnd = intervals[i][1];
            }
        }
        return res;
    }
}
