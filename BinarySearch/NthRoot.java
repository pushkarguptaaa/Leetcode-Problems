package BinarySearch;

public class NthRoot {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int NthRoot(int n, int m) {
        for(int i=0; i<=m; i++){
            long ans= helper(i, n);
            if(ans==(long)(m)) return i;
            if(ans>(long)(m)) break;
        }
        return -1;
    }

    public long helper(int j, int n){
        long ans= 1;
        for(int i=1; i<=n; i++){
            ans= ans*j;
        }
        return ans;
    }
}

class Solution1 {
    public static int NthRoot(int n, int m) {
        int left= 0;
        int right= m;
        while(left<=right){
            int mid= (left+right)/2;
            if (helper(n, m, mid)==1) return mid;
            if (helper(n, m, mid)==2) right= mid-1;
            else left= mid+1;
        }
        return -1;
    }

    public static long helper(int n, int m, int mid){
        long ans= 1;
        for(int i=1; i<=n; i++){
            ans= ans*mid;
            if(ans>(long)m) return 2;
        }
        if(ans==m) return 1;
        else return 0;
    }
}


