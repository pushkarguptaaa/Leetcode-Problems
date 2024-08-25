package Trees;

public class IsBalanced {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    int height(TreeNode node){
        if(node == null) return 0;

        int l = height(node.left);
        if(l == -1) return -1;
        int r = height(node.right);
        if(r == -1) return -1;

        if(Math.abs(l - r) > 1) return -1;

        return 1 + Math.max(l, r);
    }
}
