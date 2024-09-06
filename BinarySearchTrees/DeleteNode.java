package BinarySearchTrees;

public class DeleteNode {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);

        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            root.val = min(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    int min(TreeNode root){
        int minv = root.val;

        while(root.left != null){
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }
}
