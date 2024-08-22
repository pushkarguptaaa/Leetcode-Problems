package Trees;

import java.util.*;

public class VerticalTraversal {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair temp = q.poll();
            TreeNode node = temp.node;
            int x = temp.x;
            int y = temp.y;

            if(!mp.containsKey(x)) mp.put(x, new TreeMap<>());
            if(!mp.get(x).containsKey(y)) mp.get(x).put(y, new PriorityQueue<>());
            mp.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Pair(node.left, x-1, y+1));
            }

            if(node.right != null){
                q.offer(new Pair(node.right, x+1, y+1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> it: mp.values()){
            ans.add(new ArrayList<>());

            for(PriorityQueue<Integer> nodes: it.values()){
                while(!nodes.isEmpty()) ans.get(ans.size() - 1).add(nodes.poll());
            }
        }

        return ans;

    }
}

class Pair {
    TreeNode node;
    int x;
    int y;

    Pair(TreeNode node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
