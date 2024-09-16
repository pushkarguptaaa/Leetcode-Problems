package BinarySearchTrees;

import java.util.Stack;

public class BSTIterator {
    
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        addAll(root);
    }
    
    public int next() {
        TreeNode temp = st.pop();
        if(temp.right != null){
            addAll(temp.right);
        }
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    void addAll(TreeNode root){
        while(root != null){
            st.add(root);
            root = root.left;
        }
    }
}
