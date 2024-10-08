package BinarySearchTrees;

public class IsValidBST {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    Boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val >= max || root.val <= min) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
