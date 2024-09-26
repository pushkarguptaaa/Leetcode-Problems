package Graphs;

import java.util.*;

public class NumIslands {
    
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    cnt++;
                    helper(i, j, grid, vis, n, m);
                }
            }
        }

        return cnt;
    }

    void helper(int r, int c, char[][] grid, boolean[][] vis, int n, int m){
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false && grid[nr][nc] == '1'){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }    
    }
}

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
