package Arrays;

import java.util.*;

public class LongestSubarray {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    int maxLen(int arr[], int n, int target)
    {
        Map<Integer, Integer> mp= new HashMap<>();
        int sum= 0;
        int max= 0;
        
        for(int i=0; i<n; i++){
            sum+= arr[i];
            
            if(sum==0) max= i+1;
            if(mp.containsKey(sum-target)) max= Math.max(max, i-mp.get(sum-target));
            if(!mp.containsKey(sum)) mp.put(sum, i); 
            
        }
        return max;
    }
}
