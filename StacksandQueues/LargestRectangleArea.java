package StacksandQueues;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        Stack<Integer> st= new Stack<>();
        int lefts[]= new int[n];
        int rights[]= new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[(st.peek())]>=heights[i]) st.pop();

            if(st.isEmpty()) lefts[i]= -1;
            else lefts[i]= st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[(st.peek())]>=heights[i]) st.pop();

            if(st.isEmpty()) rights[i]= n;
            else rights[i]= st.peek();
            st.push(i);
        }
        int max= 0;

        for(int i=0; i<n; i++){
            max= Math.max(max, heights[i]*(rights[i]-lefts[i]-1));
        }

        return max;
    }
}

class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        Stack<Integer> st= new Stack<>();
        int max= 0;

        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int height= heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width= i;
                }
                else width= i-st.peek()-1;

                max= Math.max(max, height*width);
            }
            st.push(i);
        }
        return max;
    }
}
