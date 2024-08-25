package Trees;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        height(root, d);
        return d[0];
    }

    int height(TreeNode node, int[] d){
        if(node == null) return 0;

        int l = height(node.left, d);
        int r = height(node.right, d);

        d[0] = Math.max(d[0], l + r);

        return 1 + Math.max(l, r);
    }
}
