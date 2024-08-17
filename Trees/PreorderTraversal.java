package Trees;

import java.util.*;

public class PreorderTraversal {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);

        return ans;
    }

    void preorder(TreeNode node, List<Integer> ans){
        if(node == null) return;

        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
    }
}
