package BinarySearchTrees;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SearchBST {
 
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null) return null;

            if(root.val == val) return root;
            else if(root.val > val) return searchBST(root.left, val);

            return searchBST(root.right, val);
        }
    }
}
