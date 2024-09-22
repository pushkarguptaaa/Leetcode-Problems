package Graphs;

import java.util.*;

public class BFS {
    
}

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int it: adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                } 
            }
        }
        return ans;
    }
}
