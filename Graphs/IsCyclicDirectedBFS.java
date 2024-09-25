package Graphs;

import java.util.*;

public class IsCyclicDirectedBFS {
    
}

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] ind = new int[V];
        
        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                ind[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(ind[i] == 0) q.add(i);
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            
            for(int it: adj.get(node)){
                ind[it]--;
                
                if(ind[it] == 0) q.add(it);
            }
        }
        
        if(cnt == V) return false;
        
        return true;
    }
}