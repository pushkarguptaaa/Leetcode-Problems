package BinarySearchTrees;

public class MaxSumBST {
    public static void main(String[] args) {
        
    }
}

class Solution {
    int globalMaxSum = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return globalMaxSum;
    }

    Node helper(TreeNode root){
        if(root == null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Node left = helper(root.left);
        Node right = helper(root.right);

        if(left.max < root.val && root.val < right.min){
            int currentSum = left.maxsum + right.maxsum + root.val;
            globalMaxSum = Math.max(globalMaxSum, currentSum);
            return new Node(Math.min(left.min, root.val), Math.max(right.max, root.val), currentSum);
        }

        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}

class Node{
    int min;
    int max;
    int maxsum;

    Node(int min, int max, int maxsum){
        this.min = min;
        this.max = max;
        this.maxsum = maxsum;
    }
}
