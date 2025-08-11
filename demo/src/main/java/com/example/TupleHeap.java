package com.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TupleHeap {

    public void test(){
        int[][] arr = {{3, 1}, {1, 5}, {4, 2}, {1, 9}, {5, 3}, {9, 4}, {2, 6}};

        Comparator<int[]> tupleComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                for (int i = 0; i < Math.min(a.length, b.length); i++) {
                    if (a[i] != b[i]) {
                        return Integer.compare(a[i], b[i]);
                    }
                }
                return Integer.compare(a.length, b.length);
            }  
        };

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(tupleComparator);

        for (int[] tuple : arr) {
            heap.offer(tuple);
        }

        // pop and return the min element = [1, 5]
        int[] minElement = heap.poll();
        System.out.println(Util.toString(minElement));

        // peek the new min element = [1, 9]
        int[] newMin = heap.peek();
        System.out.println(Util.toString(newMin));
        // push [1, 7] to the heap, which is smaller than [1, 9]
        heap.offer(new int[]{1, 7});

        System.out.println("Removing all the elements one by one from heap");
        while(!heap.isEmpty()){
            int [] min = heap.poll();
            System.out.println(Util.toString(min));
        }
        
    }
}
