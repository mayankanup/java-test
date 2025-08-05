package com.example;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
 */
public class CombinationSumK {

    public void test(){
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        backtrack(k, n, 0, curList, result);
        return result;
    }

    private int sum(List<Integer> list){
        int result =0;
        for(int i: list){
            result +=i;
        }
        return result;
    }
    private void backtrack(int k, int n, int nextNum, List<Integer> curList, List<List<Integer>> result) {
        if (nextNum>0){
            curList.add(nextNum);
        }
        if(curList.size() >k) return;
        int sum = sum(curList);
        if(sum > n) return;
        if(sum  == n){
            if(curList.size() == k){
                result.add(new ArrayList<Integer>(curList));
            }
            return;
        }
        
        for( int i= nextNum+1; i<=9 && (i+sum)<=n; i++){
            backtrack(k, n, i, curList, result);
            curList.remove(curList.size()-1);
        }
        
    }
}
