package Graphs;

import java.util.*;

public class Kosaraju {
    
}

class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false) helper(i, vis, adj, st);
        }
        
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj2.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            vis[i] = false;
            for(int it: adj.get(i)){
                adj2.get(it).add(i);
            }
        }
        
        int scc = 0;
        
        while(!st.isEmpty()){
            int node = st.pop();
            if(vis[node] == false){
                scc++;
                helper1(node, vis, adj2);
            }
        }
        
        return scc;
    }
    
    void helper(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj,  Stack<Integer> st){
        vis[node] = true;
        
        for(int it: adj.get(node)){
            if(vis[it] == false) helper(it, vis, adj, st);
        }
        
        st.push(node);
    }
    
    void helper1(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        
        for(int it: adj.get(node)){
            if(vis[it] == false) helper1(it, vis, adj);
        }
    }

}

