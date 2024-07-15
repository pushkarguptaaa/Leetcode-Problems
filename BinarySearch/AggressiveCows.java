package BinarySearch;

import java.util.*;

public class AggressiveCows {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int high= stalls[n-1]-stalls[0];
        
        for(int dist= 1; dist<=high; dist++){
            if(canBePlaced(stalls, dist, k, n)==false) return dist-1;
        }
        return high;
    }
    
    static boolean canBePlaced(int[] stalls, int dist, int cows, int n){
        int cntCows= 1;
        int last= stalls[0];
        
        for(int i=1; i<n; i++){
            if(stalls[i]-last>=dist){
                cntCows++;
                last= stalls[i];
            }
            if(cntCows>=cows) return true;
        }
        return false;
    }
}

class Solution1 {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low= 1;
        int high= stalls[n-1]-stalls[0];
        
        while(low<=high){
            int mid= (low+high)/2;
            
            if(canBePlaced(stalls, mid, k, n)==true) low= mid+1;
            else high= mid-1;
        }
        return high;
    }
    
    static boolean canBePlaced(int[] stalls, int dist, int cows, int n){
        int cntCows= 1;
        int last= stalls[0];
        
        for(int i=1; i<n; i++){
            if(stalls[i]-last>=dist){
                cntCows++;
                last= stalls[i];
            }
            if(cntCows>=cows) return true;
        }
        return false;
    }
}
