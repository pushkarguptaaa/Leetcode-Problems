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

class Solution1
{
    int maxLenPositives(int arr[], int n, int target)
    {
        int left= 0;
        int right= 0;
        int sum= 0;
        int max= 0;

        while(right<n){
            while(left<=right && sum>target){
                left++;
                sum-= arr[left];
            }
            if(sum==target) max= Math.max(max, right-left+1);

            right++;
            if(right<n) sum+= arr[right];
        }
        return max;
    }
}

