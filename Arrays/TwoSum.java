package Arrays;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm= new HashMap<>();
        int[] ans= new int[2];
        ans[0]= -1;
        ans[1]= -1;

        int n= nums.length;

        for(int i=0; i<n; i++){
            int rqd= target-nums[i];

            if(hm.containsKey(rqd)){
                ans[0]= hm.get(rqd);
                ans[1]= i;
                return ans;
            }
            else hm.put(nums[i], i);
        }

        return ans;
    }
}


