package Graphs;

import java.util.ArrayList;

public class isCyclicDirectedDFS {
    
}

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(helper(i, vis, pathVis, adj)) return true;
        }
        
        return false;
    }
    
    boolean helper(int node, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;
        
        for(int it: adj.get(node)){
            if(vis[it] == false){
                if(helper(it, vis, pathVis, adj)) return true;
            }
            else if(pathVis[it] == true) return true;
        }
        
        pathVis[node] = false;
        return false;
    }
}