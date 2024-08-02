package StacksandQueues;

public class Celebrity {
    public static void main(String[] args) {
        
    }
}

class Solution {
    int celebrity(int M[][], int n) {
        int m= M.length;
        
        int iknow[]= new int[m];
        int knowme[]= new int [m];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(M[i][j]==1){
                    iknow[i]++;
                    knowme[j]++;
                }
            }
        }
        for(int i=0; i<m; i++){
            if(knowme[i]==m-1 && iknow[i]==0) return i;
        }
        return -1;
    }
}

class Solution1 {
    int celebrity(int M[][], int n) {
        int top= 0;
        int bot= n-1;
        
        while(top<bot){
            if(M[top][bot]==1) top++;
            else if(M[bot][top]==1) bot--;
            else{
                top++;
                bot--;
            }
        }
        
        if(top>bot) return -1;
        
        for(int i=0; i<n; i++){
            if(i==top) continue;
            if(M[top][i]==1 || M[i][top]==0) return -1;
        }
        return top;
    }
}
