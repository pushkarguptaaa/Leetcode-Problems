package Graphs;

import java.util.*;

public class SpanningTreePrims {
    
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> x.dist - y.dist);
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0, 0));
        int sum = 0;
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            
            if(vis[node] == true) continue;
            vis[node] = true;
            sum += dist;
            
            for(int[] it: adj.get(node)){
                int adjnode = it[0];
                int wt = it[1];
                
                if(vis[adjnode] == false) pq.add(new Pair(adjnode, wt));
                
            }
        }
        return sum;
    }
}

class Pair {
    int node;
    int dist;
    
    Pair(int node, int dist){
        this.dist = dist;
        this.node = node;
    }
}
