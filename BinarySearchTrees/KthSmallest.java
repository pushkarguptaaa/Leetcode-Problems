package BinarySearchTrees;

public class KthSmallest {
    
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[]{0};
        inorder(root, k, new int[]{0}, ans);

        return ans[0];
    }

    void inorder(TreeNode root, int k, int[] cnt, int[] ans){
        if(root == null || cnt[0] >= k) return;

        inorder(root.left, k, cnt, ans);

        cnt[0]++;
        if(cnt[0] == k){
            ans[0] = root.val;
            return;
        }

        inorder(root.right, k, cnt, ans);
    }
}