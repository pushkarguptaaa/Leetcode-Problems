package GreedyAlgorithm;

import java.util.*;

public class MinPartition {
    public static void main(String[] args) {
        
    }
}

class Solution{
    static List<Integer> minPartition(int N)
    {
        int coins[]= {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int n= coins.length;
        List<Integer> ans= new ArrayList<>();
	    
	    for(int i=n-1; i>=0; i--){
	        while(coins[i]<=N){
	            N-= coins[i];
	            ans.add(coins[i]);
	        }
	        if(N==0) break;
	    }
	    return ans;
        
    }
}
