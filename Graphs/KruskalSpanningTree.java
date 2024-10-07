package Graphs;

import java.util.*;


public class KruskalSpanningTree {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        ArrayList<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            for(int[] it: adj.get(i)){
               int node = i;
               int adjnode = it[0];
               int wt = it[1];
               Edge temp = new Edge(node, adjnode, wt);
               edges.add(temp);
            }
        }
        
        Collections.sort(edges);
        Disjoint dt = new Disjoint(V);
        int mstwt = 0;
        
        for(Edge it: edges){
            int u = it.node;
            int v = it.dest;
            int w = it.wt;
            
            if(dt.find(u) != dt.find(v)){
                mstwt+= w;
                dt.unionSet(u, v);
            }
        }
        
        return mstwt;
        
    }
}

class Edge implements Comparable<Edge> {
    int node;
    int dest;
    int wt;
    
    Edge(int node, int dest, int wt){
        this.dest = dest;
        this.node = node;
        this.wt = wt;
    }
    
    public int compareTo(Edge compareEdge){
        return this.wt - compareEdge.wt;
    }
}