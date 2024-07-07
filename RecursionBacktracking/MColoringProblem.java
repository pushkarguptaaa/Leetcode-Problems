package RecursionBacktracking;

public class MColoringProblem {
    public static void main(String[] args) {
        
    }
}

class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colors= new int[n];
        for(int i=0; i<n; i++){
            colors[i]= 0;
        }
        
        if(recHelper(0, graph, colors, m, n)== true) return true;
        
        return false;
    }
    
    boolean recHelper(int node, boolean[][] graph, int[] colors, int m, int n){
        if(node==n) return true;
        
        for(int c=1; c<=m; c++){
            if(isValid(node, graph, colors, c, n)){
                colors[node]= c;
                if(recHelper(node+1, graph, colors, m, n)) return true;
                colors[node]= 0;
            }
        }
        return false;
    }
    
    boolean isValid(int node, boolean[][] graph, int[] colors, int c, int n){
        for(int i=0; i<n; i++){
            if(graph[node][i] && colors[i]==c) return false;
        }
        return true;
    }
}
