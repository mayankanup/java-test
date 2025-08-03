package com.example;

public class KthSmallestInSortedMatrix {
    public void test(){
        int[][] matrix = 
                        {{10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {24, 29, 37, 48},
                        {32, 33, 39, 50}};
        int k = 3;
        int result = kthSmallest(matrix, k);

        System.out.println(result);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;
        int col = n - 1;
        int row = 0;
        // Traverse from the top-right corner
        while (col >= 0 && row < n) {
            if (matrix[row][col] <= target) {
                count += (col + 1);
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}
