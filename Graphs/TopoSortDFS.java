package Graphs;

import java.util.*;

public class TopoSortDFS {
    
}

class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       boolean[] vis = new boolean[V];
       Stack<Integer> st = new Stack<>();
       
       for(int i = 0; i < V; i++){
           if(vis[i] == false) helper(i, vis, adj, st);
       }
       
       int[] ans = new int[V];
       int i = 0;
       
       while(!st.isEmpty()){
           ans[i++] = st.pop();
       }
       
       return ans;
    }
    
    static void helper(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj,  Stack<Integer> st){
        vis[node] = true;
        
        for(int it: adj.get(node)){
            if(vis[it] == false) helper(it, vis, adj, st);
        }
        
        st.push(node);
    }
}