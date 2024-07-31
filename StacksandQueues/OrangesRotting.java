package StacksandQueues;

import java.util.*;

public class OrangesRotting {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int n= grid.length;
        int m= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int cntFresh= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                if(grid[i][j]!=0) cntFresh++;
            }
        }

        if(cntFresh==0) return 0;

        int cnt= 0;
        int minCnt= 0;
        int[] dx= {0,0,1,-1};
        int[] dy= {1,-1,0,0};

        while(!q.isEmpty()){
            int s= q.size();
            cnt+= s;

            for(int i=0; i<s; i++){
                int pt[]= q.poll();
                for(int j=0; j<4; j++){
                    int x= pt[0]+dx[j];
                    int y= pt[1]+dy[j];

                    if(x<0 || y<0 || x>=n || y>=m || grid[x][y]==2 || grid[x][y]==0) continue;
                    
                    grid[x][y]= 2;
                    q.offer(new int[]{x,y});
                }
            }
            if(q.size()!=0) minCnt++;
        }
        return (cnt==cntFresh) ? minCnt : -1; 
    }
}
