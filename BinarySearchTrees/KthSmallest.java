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

class Solution1
{
    public int kthLargest(TreeNode root,int K)
    {
        int[] ans = new int[]{0};
        revinorder(root, K, new int[]{0}, ans);

        return ans[0];
    }
    
    void revinorder(TreeNode root, int K, int[] cnt, int[] ans){
        if(root == null || cnt[0] >= K) return;

        revinorder(root.right, K, cnt, ans);

        cnt[0]++;
        if(cnt[0] == K){
            ans[0] = root.val;
            return;
        }

        revinorder(root.left, K, cnt, ans);
    }
}