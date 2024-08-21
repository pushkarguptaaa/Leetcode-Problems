package Trees;

import java.util.*;

public class TopView {
    public static void main(String[] args) {
        
    }
}

class Solution {
    
    static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            int line = temp.getValue();
            TreeNode node = temp.getKey();
            
            if(!mp.containsKey(line)) mp.put(line, node.val);
            
            if(node.left != null){
                q.add(new Pair(node.left, line - 1));
            }
            
            if(node.right != null){
                q.add(new Pair(node.right, line + 1));
            }
        }
        
        for(int value: mp.values()) ans.add(value);
        
        return ans;
    }
}

class Pair {
    TreeNode node;
    int line;
    
    Pair(TreeNode node, int line){
        this.node = node;
        this.line = line;
    }
    
    TreeNode getKey(){
        return node;
    }
    
    int getValue(){
        return line;
    }
}
