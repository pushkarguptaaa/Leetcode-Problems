package Trees;

import java.util.*;

public class InorderTraversal {
    public static void main(String[] args) {
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res;
    }
    
    void inorder(TreeNode node, List<Integer> res){
        if(node == null) return;

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

}