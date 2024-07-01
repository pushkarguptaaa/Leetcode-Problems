package RecursionBacktracking;

import java.util.*;

public class SubsetSums {
    public static void main(String[] args) {
        
    }
}

class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans= new ArrayList<>();
        
        subsetHelper(0,0,n,arr,ans);
        Collections.sort(ans);
        
        return ans;
    }
    
    void subsetHelper(int ind, int sum, int n, ArrayList<Integer> arr, ArrayList<Integer> ans){
        if(ind==n){
            ans.add(sum);
            return;
        }
        
        subsetHelper(ind+1, sum+arr.get(ind), n, arr, ans);
        subsetHelper(ind+1, sum, n, arr, ans);
    }
}
