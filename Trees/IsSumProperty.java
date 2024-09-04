package Trees;

public class IsSumProperty {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    public static int isSumProperty(TreeNode root)
    {
        if(root == null) return 1;
        if(root.left == null && root.right == null) return 1;
        
        int leftd = root.left != null ? root.left.val : 0;
        int rightd = root.right != null ? root.right.val : 0;
        
        if(leftd + rightd != root.val) return 0;
        
        int left = isSumProperty(root.left);
        int right = isSumProperty(root.right);
        
        return left == 1 && right == 1 ? 1: 0;
        
    }
}
