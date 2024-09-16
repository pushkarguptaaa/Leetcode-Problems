package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SerialiseDeserialise {
public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null){
                res.append("n ");
                continue;
            }

            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;

        Queue<TreeNode> q = new LinkedList<>();
        String ans[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ans[0]));
        q.add(root);

        for(int i = 1; i < ans.length; i++){
            TreeNode node = q.poll();
            
            if(!ans[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(ans[i]));
                node.left = left;
                q.add(left);
            }

            if(!ans[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(ans[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }
}


