package LLAndArrays;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int n= nums.length;
        Set<Integer> st= new HashSet<>();

        for(int i=0; i<n; i++){
            st.add(nums[i]);
        }

        int j=0;
        for(int it: st){
            nums[j]= it;
            j++;
        }

        return st.size();
    }
}

class Solution1 {
    public int removeDuplicates(int[] nums) {
        int n= nums.length;
        int i= 0;

        for(int j=1; j<n; j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]= nums[j];
            }
        }
        return i+1;
    }
}