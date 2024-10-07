package Graphs;

public class Disjoint {
    int[] size;
    int[] par;
    
    public Disjoint(int n) {
        size = new int[n + 1]; 
        par = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            par[i] = i;
        }
    }
    
	int find(int X)
        {
          if(X == par[X]) return X;
          int parent = find(par[X]);
          par[X] = parent;
          return par[X];
	}
	void unionSet(int X,int Z)
        {
         int upx = find(X);
         int upz = find(Z);
         
         if(upx == upz) return;
         if(size[upx] < size[upz]){
             par[upx] = upz;
             size[upz] = size[upz] + size[upx];
         }
         else{
             par[upz] = upx;
             size[upx] = size[upx] + size[upz];
         }
	}
}
