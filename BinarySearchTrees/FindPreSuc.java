package BinarySearchTrees;

public class FindPreSuc {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public static void findPreSuc(TreeNode root, TreeNode[] pre, TreeNode[] suc, int key) {
        pre[0] = null;
        suc[0] = null;
        
        while(root != null){
            if(root.val < key){
                pre[0] = root;
                root = root.right;
            } else if(root.val > key){
                suc[0] = root;
                root = root.left;
            }
            else{
                if(root.left != null){
                    TreeNode temp = root.left;
                    while(temp.right != null) temp = temp.right;
                    pre[0] = temp;
                } 
                if(root.right != null){
                    TreeNode temp = root.right;
                    while(temp.left != null) temp = temp.left;
                    suc[0] = temp;
                }
                break;
            }
        }
    }
}
