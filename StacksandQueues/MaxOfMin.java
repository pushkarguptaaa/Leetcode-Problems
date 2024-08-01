package StacksandQueues;

import java.util.Stack;

public class MaxOfMin {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public static void maxOfMin(int[] arr, int n) {
        
        int[] result = new int[n];
        
        
        for (int windowSize = 1; windowSize <= n; windowSize++) {
            int maxOfMins = Integer.MIN_VALUE;
            
            
            for (int i = 0; i <= n - windowSize; i++) {
                int minInWindow = Integer.MAX_VALUE;
                
                
                for (int j = i; j < i + windowSize; j++) {
                    minInWindow = Math.min(minInWindow, arr[j]);
                }
                
                
                maxOfMins = Math.max(maxOfMins, minInWindow);
            }
            
            
            result[windowSize - 1] = maxOfMins;
        }
    }
}

class Solution1
{
    static int[] maxOfMin(int[] arr, int n) 
    {
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }


        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i-1] = ans[i];
        }
        
        return res;
    }
}