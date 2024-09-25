package Graphs;

import java.util.*;

public class TopoSortBFS {
    
}

class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ind = new int[V];
        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                ind[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[V];
        
        for(int i = 0; i < V; i++){
            if(ind[i] == 0) q.add(i);
        }
        
        int i = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            
            for(int it: adj.get(node)){
                ind[it]--;
                if(ind[it] == 0) q.add(it);
            }
        }
        return ans;
    }
}
