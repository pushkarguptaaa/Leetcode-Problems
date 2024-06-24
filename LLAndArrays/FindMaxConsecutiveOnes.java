package LLAndArrays;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n= nums.length;
        int cnt= 0;
        int max= 0;

        for(int i=0; i<n; i++){
            if(nums[i]==1) cnt++;
            else cnt= 0;
            max= Math.max(max,cnt);
        }
        return max;
    }
}
