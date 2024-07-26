package StacksandQueues;

import java.util.*;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        
    }    
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st= new Stack<>();
        Map<Integer, Integer> mp= new HashMap<>();

        for(int i= nums2.length-1; i>=0; i--){
            int num= nums2[i];

            while(!st.isEmpty() && st.peek()<=num) st.pop();

            if(st.isEmpty()) mp.put(num, -1);
            else mp.put(num, st.peek());

            st.push(num);
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i]= mp.containsKey(nums1[i])? mp.get(nums1[i]): -1;
        }
        return nums1;
    }
}


