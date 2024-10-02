package Graphs;

import java.util.ArrayList;

public class BellmanFord {
    
}

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dist[] = new int[V];
        for(int i = 0; i < V; i++) dist[i] = (int)1e8;
        
        dist[S] = 0;
        
        for(int i = 0; i < V; i++){
            for(ArrayList<Integer> it: edges){
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);
                if(dist[u] != 1e8 && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        for(ArrayList<Integer> it: edges){
            int u = it.get(0);
            int v = it.get(1);
            int w = it.get(2);
            if(dist[u] != 1e8 && dist[u] + w < dist[v]){
                dist[v] = dist[u] + w;
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        
        return dist;
    }
}
