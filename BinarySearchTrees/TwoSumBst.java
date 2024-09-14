package BinarySearchTrees;

import java.util.*;

public class TwoSumBst {
    
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    boolean helper(TreeNode root, int k, Set<Integer> set){
        if(root == null) return false;

        if(helper(root.left, k, set)) return true;

        if(set.contains(k - root.val)) return true;
        set.add(root.val);

        return helper(root.right, k, set);
    }
}
