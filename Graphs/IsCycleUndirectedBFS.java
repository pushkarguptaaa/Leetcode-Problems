package Graphs;

import java.util.*;

public class IsCycleUndirectedBFS {
    
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(helper(i, vis, adj)) return true;
            }
        }
        return false;
    }
    
    boolean helper(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        vis[src] = true;
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            
            for(int it: adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(new Pair(it, node));
                }
                
                else if(it != parent) return true;
            }
        }
        return false;
    }
}

class Pair{
    int first;
    int second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
