package Trees;

public class IsSameTree {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;

        return p.val == q.val && isSameTree(p.left, q.left) &&  isSameTree(p.right, q.right);
    }
}
