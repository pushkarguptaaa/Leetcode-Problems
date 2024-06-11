package Arrays;

import java.util.*;

public class LongestConsecutive {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        if(n==0) return 0;
        int longest= 1;

        for(int i=0; i<n; i++){
            int count=1;
            int x= nums[i];

            while(ls(nums, x+1)==true){
                x++;
                count++;
            }
            longest= Math.max(count,longest);
        }

        return longest;
    }

    public boolean ls(int[] nums, int target){
        int n= nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==target) return true;
        }

        return false;
    }
}

class Solution1 {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        if(n==0) return 0;
        int prev= Integer.MIN_VALUE;
        int longest= 1;
        int count= 0;

        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            if(nums[i]-1==prev){
                count++;
                prev= nums[i];
            }
            else if(nums[i]==prev) continue;
            else{
                count= 1;
                prev= nums[i];
            }

            longest= Math.max(longest, count);
        }

        return longest;
    }
}

class Solution2 {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        if(n==0) return 0;

        Set<Integer> st= new HashSet<>();
        for(int i=0; i<n; i++){
            st.add(nums[i]);
        }
        int longest= 1;

        for(int it: st){
            if(!st.contains(it-1)){
                int count= 1;
                int x= it;

                while(st.contains(x+1)){
                    x++;
                    count++;
                }

                longest= Math.max(longest, count);
            }

        }

        return longest;
    }
}
