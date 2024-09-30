package Graphs;

import java.util.*;

public class Dijkstra {
    
}

class Pair{
    int dist;
    int node;
    
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int [] dis = new int[V];
        for(int i = 0; i < V; i++) dis[i] = (int)1e9;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.dist - y.dist);
        dis[S] = 0;
        
        pq.add(new Pair(0, S));
        
        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int wt = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);
                
                if(wt + dist < dis[adjnode]){
                    dis[adjnode] = wt + dist;
                    pq.add(new Pair(dis[adjnode], adjnode));
                }
            }
        }
        return dis;
    }
}
