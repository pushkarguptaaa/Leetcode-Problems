package Graphs;

import java.util.ArrayList;

public class IsCycleUndirectedDFS {
    
}

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(helper(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
    
    boolean helper(int src, int parent,  boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[src] = true;
        
        for(int it: adj.get(src)){
            if(vis[it] == false){
                if(helper(it, src, vis, adj)) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
}
