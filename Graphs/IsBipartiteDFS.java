package Graphs;

public class IsBipartiteDFS {
    
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];

        for(int i = 0; i < n; i++) colors[i] = -1;

        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                if(helper(i, 0, graph, colors) == false) return false;
            }
        }
        return true;
    }

    boolean helper(int src, int col, int[][] graph, int[] colors){
        colors[src] = col;

        for(int it: graph[src]){
            if(colors[it] == -1){
                if(helper(it, 1 - col, graph, colors) == false) return false;
            }
            else if(colors[it] == col) return false;
        }
        return true;
    }
}
