package Arrays;

public class MaxSubarray {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length;
        long sum= 0;
        long max= Long.MIN_VALUE;

        for(int i=0; i<n; i++){
            sum+=nums[i];

            if(sum>max) max= sum;

            if(sum<0) sum=0;
        }

        return ((int)max);
    }
}
