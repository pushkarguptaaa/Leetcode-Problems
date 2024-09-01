package Trees;

public class MaxPathSum {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPath(root, max);

        return max[0];
    }

    int maxPath(TreeNode node, int[] max){
        if(node == null) return 0;

        int left = Math.max(0, maxPath(node.left, max));
        int right = Math.max(0, maxPath(node.right, max));

        max[0] = Math.max(max[0], node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
