package Arrays;

import java.util.*;

public class SubarraySum {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        int cnt= 0;

        for(int i=0; i<n; i++){
            int sum= 0;
            for(int j=i; j<n; j++){
                sum+= nums[j];

                if(sum==k) cnt++;
            }
        }
        return cnt;
    }
}

class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        int sum= 0;
        int cnt= 0;
        Map<Integer, Integer> mp= new HashMap<>();
        mp.put(0,1);

        for(int i=0; i<n; i++){
            sum+= nums[i];

            cnt+= mp.getOrDefault(sum-k,0);

            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
}
