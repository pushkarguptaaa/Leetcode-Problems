package Trees;

import java.util.*;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Boolean flag = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> res = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(flag) res.add(node.val);
                else res.add(0, node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            flag = !flag;
            ans.add(res);
        }
        return ans;
    }
}
