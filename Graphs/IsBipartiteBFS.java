package Graphs;

import java.util.*;

public class IsBipartiteBFS {
    
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];

        for(int i = 0; i < n; i++) colors[i] = -1;

        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                if(helper(i, graph, colors) == false) return false;
            }
        }
        return true;
    }

    boolean helper(int src, int[][] graph, int[] colors){
        Queue<Integer> q = new LinkedList<>();
        colors[src] = -1;
        q.add(src);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int it: graph[node]){
                if(colors[it] == -1){
                    colors[it] = 1 - colors[node];
                    q.add(it);
                }
                else if(colors[it] == colors[node]) return false;
            }
        }
        return true;
    }
}
