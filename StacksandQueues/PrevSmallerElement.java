package StacksandQueues;

import java.util.*;

public class PrevSmallerElement {
    public static void main(String[] args) {
        
    }
}

class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        Stack<Integer> st= new Stack<>();
        ArrayList<Integer> ans= new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && st.peek() >= a[i]) st.pop();
            
            if(st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            
            st.push(a[i]);
        }
        
        return ans;
    }
}
