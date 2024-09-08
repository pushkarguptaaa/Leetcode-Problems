package BinarySearchTrees;

public class BstFromPreorder {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE, new int[1]);
    }

    TreeNode helper(int[] preorder, int max, int[] i){
        if(i[0] == preorder.length || preorder[i[0]] >= max) return null;

        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = helper(preorder, root.val, i);
        root.right = helper(preorder, max, i);

        return root;
    }
}
