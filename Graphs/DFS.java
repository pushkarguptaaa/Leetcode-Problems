package Graphs;

import java.util.ArrayList;

public class DFS {
    
}

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        return helper(0, vis, ans, adj);
    }
    
    ArrayList<Integer> helper(int node, boolean[] vis,  ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        ans.add(node);
        
        for(int it: adj.get(node)){
            if(vis[it] == false){
                helper(it, vis, ans, adj);
            }
        }
        
        return ans;
    }
}
