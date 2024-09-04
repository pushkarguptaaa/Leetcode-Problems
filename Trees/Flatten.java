package Trees;

public class Flatten {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        flat(root, prev);
    }

    void flat(TreeNode node, TreeNode[] prev){
        if(node == null) return;

        flat(node.right, prev);
        flat(node.left, prev);

        node.right = prev[0];
        node.left = null;
        prev[0] = node;
    }
}
