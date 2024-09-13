package BinarySearchTrees;

public class Ceil {
    
}

class Tree {
    int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        int ceil = -1;
        
        while(root != null){
            if(root.val == key){
                ceil = root.val;
                return ceil;
            }
            
            if(key < root.val){
                ceil = root.val;
                root = root.left;
            }
            else root = root.right;
        }
        return ceil;
    }
}
