package Trees;

import java.util.*;

public class BinaryTreePaths {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;

        treePaths(root, ans, new ArrayList<>());

        return ans;
    }

    void treePaths(TreeNode node, List<String> ans, List<String> res){
        res.add(Integer.toString(node.val));

        if(node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();

            for(String s : res){
                sb.append(s);
                sb.append("->");
            }
            ans.add(sb.substring(0, sb.length() - 2));

            return;
        }

        if(node.left != null){
            treePaths(node.left, ans, res);
            res.remove(res.size() - 1);
        }

        if(node.right != null){
            treePaths(node.right, ans, res);
            res.remove(res.size() - 1);
        }
    }
}
