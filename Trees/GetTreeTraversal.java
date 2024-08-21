package Trees;

import java.util.*;

public class GetTreeTraversal {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        Stack<Pair> st = new Stack<>();

        if(root == null) return new ArrayList<>();

        st.add(new Pair(root, 1));

        while(!st.isEmpty()){
            Pair temp = st.pop();

            if(temp.getVal() == 1){
                pre.add(temp.getKey().val);
                temp.setVal(2);
                st.push(temp);
                
                if(temp.getKey().left != null){
                    st.add(new Pair(temp.getKey().left, 1));
                }
            }

            else if(temp.getVal() == 2){
                in.add(temp.getKey().val);
                temp.setVal(3);
                st.push(temp);
                
                if(temp.getKey().right != null){
                    st.add(new Pair(temp.getKey().right, 1));
                }
            }

            else pos.add(temp.getKey().val);
            
        }

        ans.add(in);
        ans.add(pre);
        ans.add(pos);

        return ans;
    }
}

class Pair {
    TreeNode node;
    int val;

    Pair(TreeNode node, int val){
        this.node = node;
        this.val = val;
    }

    TreeNode getKey(){
        return this.node;
    }

    int getVal(){
        return this.val;
    }

    void setVal(int val){
        this.val = val;
    }
}
