package RecursionBacktracking;

import java.util.*;

public class RatMazeProblem {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans= new ArrayList<>();
        int[][] vis= new int[n][n];
        String res= "";
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                vis[i][j]= 0;
            }
        }
        vis[0][0]= 1;
        
        if(m[0][0]==1) recHelper(0, 0, m, n, res, ans, vis);
        
        return ans;
    }
    
    void recHelper(int i, int j, int[][] m, int n, String res, ArrayList<String> ans, int[][] vis){
        if(i== n-1 && j== n-1){
            ans.add(res);
            
            return;
        }
        
        if(i+1<n && vis[i+1][j]==0 && m[i+1][j]==1){
            vis[i+1][j]= 1;
            recHelper(i+1, j, m, n, res+'D', ans, vis);
            vis[i+1][j]= 0;
        }
        
        if(j-1>=0 && vis[i][j-1]==0 && m[i][j-1]==1){
            vis[i][j-1]= 1;
            recHelper(i, j-1, m, n, res+'L', ans, vis);
            vis[i][j-1]= 0;
        }
        
        if(j+1<n && vis[i][j+1]==0 && m[i][j+1]==1){
            vis[i][j+1]= 1;
            recHelper(i, j+1, m, n, res+'R', ans, vis);
            vis[i][j+1]= 0;
        }
        
        if(i-1>=0 && vis[i-1][j]==0 && m[i-1][j]==1){
            vis[i-1][j]= 1;
            recHelper(i-1, j, m, n, res+'U', ans, vis);
            vis[i-1][j]= 0;
        }
    }
}

class Solution1 {
    public ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans= new ArrayList<>();
        int[][] vis= new int[n][n];
        String res= "";
        int di[]= {1,0,0,-1};
        int dj[]= {0,-1,1,0};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                vis[i][j]= 0;
            }
        }
        vis[0][0]= 1;
        
        if(m[0][0]==1) recHelper(0, 0, m, n, res, ans, vis, di, dj);
        
        return ans;
    }
    
    void recHelper(int i, int j, int[][] m, int n, String res, ArrayList<String> ans, int[][] vis, int[] di, int[] dj){
        if(i== n-1 && j== n-1){
            ans.add(res);
            
            return;
        }
        
        String dir= "DLRU";
        
        for(int ind= 0; ind<4; ind++){
            int nexti= i+di[ind];
            int nextj= j+dj[ind];
            
            if(nexti<n && nextj<n && nexti>=0 && nextj>=0 && vis[nexti][nextj]==0 && m[nexti][nextj]==1){
                vis[nexti][nextj]= 1;
                recHelper(nexti, nextj, m, n, res+ dir.charAt(ind), ans, vis, di, dj);
                vis[nexti][nextj]= 0;
            }
        }
    }
    
}
