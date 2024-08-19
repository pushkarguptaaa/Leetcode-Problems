package Trees;

import java.util.*;

public class PostorderTraversal {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        postorder(root, ans);

        return ans;
    }

    void postorder(TreeNode node,  List<Integer> ans){
        if(node == null) return;

        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.val);
    }
}
