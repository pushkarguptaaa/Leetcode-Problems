package Trees;

import java.util.*;

public class BuildTreeFromPost {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }

        TreeNode root = build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, mp);

        return root;
    }

    TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> mp){
        if(ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(postorder[pe]);

        int inroot = mp.get(root.val);
        int numsleft = inroot - is;

        root.left = build(inorder, is, inroot - 1, postorder, ps, ps + numsleft - 1, mp);
        root.right = build(inorder, inroot + 1, ie, postorder, ps+ numsleft, pe - 1, mp);

        return root;
    }
}
