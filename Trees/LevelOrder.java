package Trees;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return ans;

        q.offer(root);

        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> res = new ArrayList<>();

            for(int i = 0; i<level; i++){
                TreeNode node = q.poll();

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

                res.add(node.val);
            }
            ans.add(res);
        }
        return ans;
    }
}
