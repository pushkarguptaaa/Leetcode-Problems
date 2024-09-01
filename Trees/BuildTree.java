package Trees;

import java.util.*;

public class BuildTree {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, mp);

        return root;
    }

    TreeNode buildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend, Map<Integer, Integer> mp){
        if(prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot = mp.get(root.val);
        int numsleft = inroot - instart;

        root.left = buildTree(inorder, instart, inroot - 1, preorder, prestart + 1, prestart + numsleft, mp);
        root.right = buildTree(inorder, inroot + 1, inend, preorder, prestart + numsleft + 1, preend, mp);

        return root;
    }
}
