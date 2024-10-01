package Graphs;

import java.util.*;

public class ShortestPath {
    
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        int[] dis = new int[n + 1];
        int[] par = new int[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> x.dist - y.dist);
        
        for(int i = 1; i <= n; i++){
            dis[i] = (int)1e9;
            par[i] = i;
        }
        
        dis[1] = 0;
        pq.add(new Pair(1, 0));
        
        while(!pq.isEmpty()){
            int distt = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            
            for(Pair it: adj.get(node)){
                int adjnode = it.node;
                int adjdist = it.dist;
                
                if(distt + adjdist < dis[adjnode]){
                    dis[adjnode] = distt + adjdist;
                    pq.add(new Pair(adjnode, dis[adjnode]));
                    par[adjnode] = node;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(dis[n] == 1e9){
            ans.add(-1);
            return ans;
        }
        
        int node = n;
        
        while(node != par[node]){
            ans.add(node);
            node = par[node];
        }
        
        ans.add(1);
        ans.add(dis[n]);
        Collections.reverse(ans);
        return ans;
    }
}

class Pair{
    int dist;
    int node;
    
    Pair(int node, int dist){
        this.dist = dist;
        this.node = node;
    }
}
