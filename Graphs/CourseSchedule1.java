package Graphs;

import java.util.*;

public class CourseSchedule1 {
    
}

class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int[] ans = new int[V];
        int i = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        if(i == V) return true;

        return false;
    }
}
