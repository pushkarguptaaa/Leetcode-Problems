package Trees;

import java.util.*;

public class LeftandRightViewTree {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        rsview(root, res, 0);

        return res;
    }

    void rsview(TreeNode curr, List<Integer> res, int depth){
        if(curr == null) return;

        if(depth == res.size()) res.add(curr.val);

        rsview(curr.right, res, depth + 1);
        rsview(curr.left, res, depth + 1);
    }
}

class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        rsview(root, res, 0);

        return res;
    }

    void rsview(TreeNode curr, List<Integer> res, int depth){
        if(curr == null) return;

        if(depth == res.size()) res.add(curr.val);

        rsview(curr.left, res, depth + 1);
        rsview(curr.right, res, depth + 1);
    }
}

