package Trees;

import java.util.*;

public class BottomView {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    public ArrayList <Integer> bottomView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        root.hd = 0;
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            int hd = temp.hd;
            mp.put(hd, temp.val);
            
            if(temp.left != null){
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            
            if(temp.right != null){
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
        
    }
}
