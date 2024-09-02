package Trees;

public class IsSymmetric {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || symmetric(root.left, root.right);
    }

    boolean symmetric(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;

        if(left.val != right.val) return false;

        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
