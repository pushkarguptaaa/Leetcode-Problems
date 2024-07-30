package StacksandQueues;

import java.util.*;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int ans[]= new int[n-k+1];
        
        for(int i=0; i<=n-k; i++){
            int max= Integer.MIN_VALUE;

            for(int j=i; j<=i+k-1; j++){
                max= Math.max(max, nums[j]);
            }
            ans[i]= max;
        }
        return ans;
    }
}

class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int ans[]= new int[n-k+1];
        int pt= 0;
        Deque<Integer> dq= new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peek()==i-k) dq.poll();

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]) dq.pollLast();

            dq.offer(i);

            if(i>=k-1) ans[pt++]= nums[dq.peek()];
        }
        return ans;
    }
}
