package Graphs;

public class Disjoint {
    int[] size; 
    
    public Disjoint(int n) {
        size = new int[n + 1]; 
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
        }
    }
    
	int find(int A[],int X)
        {
          if(X == A[X]) return X;
          int par = find(A, A[X]);
          A[X] = par;
          return A[X];
	}
	void unionSet(int A[],int X,int Z)
        {
         int upx = find(A, X);
         int upz = find(A, Z);
         
         if(upx == upz) return;
         if(size[upx] < size[upz]){
             A[upx] = upz;
             size[upz] = size[upz] + size[upx];
         }
         else{
             A[upz] = upx;
             size[upx] = size[upx] + size[upz];
         }
	}
}
