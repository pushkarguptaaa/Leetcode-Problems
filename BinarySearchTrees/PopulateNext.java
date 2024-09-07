package BinarySearchTrees;

public class PopulateNext {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public TreeNode connect(TreeNode root) {
        TreeNode curr = root;
        TreeNode nxt = curr != null ? curr.left : null;

        while(curr != null && nxt != null){
            curr.left.next = curr.right;

            if(curr.next != null){
                curr.right.next = curr.next.left;
            }

            curr = curr.next;

            if(curr == null){
                curr = nxt;
                nxt = curr.left;
            }
        }
        return root;
    }
}
