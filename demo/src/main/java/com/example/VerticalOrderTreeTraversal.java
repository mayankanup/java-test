package com.example;

import java.util.*;

public class VerticalOrderTreeTraversal {
    public void test() {
        TreeNode root = createTree();
        verticalOrderTraverseTree(root);
    }

    private TreeNode createTree() {
        TreeNode root = new TreeNode(1);

        //Level 1 nodes
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.left = n2;
        root.right = n3;

        //Level 2 nodes
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;

        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n3.left = n6;
        n3.right = n7;

        //Level 3 nodes
        TreeNode n8 = new TreeNode(8);
        n6.right = n8;
        
        TreeNode n9 = new TreeNode(9);
        n7.right = n9;
        return root;
    }

    private void verticalOrderTraverseTree(TreeNode root) {
        Map<Integer, List<Integer>> verticalOrderMap = new TreeMap<Integer, List<Integer>> ();
        int currVerticalIndex = 0;
        preOrderTraversal(root, currVerticalIndex, verticalOrderMap);
        for(Integer i : verticalOrderMap.keySet()){
            int [] nodes = verticalOrderMap.get(i).stream()
                              .mapToInt(Integer::intValue)
                              .toArray();
            System.out.println(i + " --> " + Util.toString(nodes));
        }
    }

    private void preOrderTraversal(TreeNode node, int currVerticalIndex, Map<Integer, List<Integer>> verticalOrderMap) {
        if(node ==null) return;
        if(!verticalOrderMap.containsKey(currVerticalIndex)){
            verticalOrderMap.put(currVerticalIndex, new ArrayList<Integer> ());
        }
        verticalOrderMap.get(currVerticalIndex).add(node.val);
        preOrderTraversal(node.left, currVerticalIndex-1, verticalOrderMap);
        preOrderTraversal(node.right, currVerticalIndex+1, verticalOrderMap);
    }
}

//A Binary Tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
