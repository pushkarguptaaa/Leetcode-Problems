package BinarySearchTrees;

public class Floor {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public static int floor(TreeNode root, int x) {
    int floor = -1;
    
    while(root != null){
        if(root.val == x){
            floor = root.val;
            return floor;
        }
        
        if(x > root.val){
            floor = root.val;
            root = root.right;
        }
        else root = root.left;
    }
    return floor;
}
}
