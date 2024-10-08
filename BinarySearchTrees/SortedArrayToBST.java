package BinarySearchTrees;

public class SortedArrayToBST {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int l, int r){
        if(l > r) return null;

        int mid = (l + r) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);

        return root;
    }
}
