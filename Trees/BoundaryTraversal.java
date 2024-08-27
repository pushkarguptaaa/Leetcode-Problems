package Trees;

import java.util.*;

public class BoundaryTraversal {
    public static void main(String[] args) {
        
    }
}

class Solution
{
	ArrayList <Integer> boundary(TreeNode node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(node == null) return ans;
	    if(!isLeaf(node)) ans.add(node.val);
	    left(node, ans);
	    leaves(node, ans);
	    right(node, ans);
	    
	    return ans;
	}
	
	void left(TreeNode node, ArrayList<Integer> ans){
	    TreeNode curr = node.left;
	    while(curr != null){
	        if(!isLeaf(curr)) ans.add(curr.val);
	        if(curr.left != null) curr = curr.left;
	        else curr = curr.right;
	    }
	}
	
	void right (TreeNode node, ArrayList<Integer> ans){
	    ArrayList<Integer> temp = new ArrayList<>();
	    TreeNode curr = node.right;
	    while(curr != null){
	        if(!isLeaf(curr)) temp.add(curr.val);
	        if(curr.right != null) curr = curr.right;
	        else curr = curr.left;
	    }
	    for(int i = temp.size() - 1; i >= 0; i--){
	        ans.add(temp.get(i));
	    }
	 }
	 
	 void leaves(TreeNode node, ArrayList<Integer> ans){
	     if(isLeaf(node)) ans.add(node.val);
	     
	     if(node.left != null) leaves(node.left, ans);
	     if(node.right != null) leaves(node.right, ans);
	 }
	 
	 boolean isLeaf(TreeNode node){
	     if(node.left == null && node.right == null) return true;
	     else return false;
	 }
}
