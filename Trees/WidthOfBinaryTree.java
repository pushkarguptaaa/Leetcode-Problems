package Trees;

import java.util.*;

public class WidthOfBinaryTree {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().ind;
            int first = 0;
            int last = 0;


            for(int i = 0; i < size; i++){
                TreeNode node = q.peek().node;
                int currind = q.peek().ind - min;
                q.poll();

                if(i == 0) first = currind;
                if(i == size - 1) last = currind;

                if(node.left != null) q.offer(new Pair(node.left, currind * 2 + 1));
                if(node.right != null) q.offer(new Pair(node.right, currind * 2 + 2));

                ans = Math.max(ans, last - first + 1);
            }
        }
        return ans;
    }
}

class Pair {
    TreeNode node;
    int ind;

    Pair(TreeNode node, int ind){
        this.node = node;
        this.ind = ind;
    }
}
