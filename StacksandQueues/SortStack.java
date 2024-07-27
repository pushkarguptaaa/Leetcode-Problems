package StacksandQueues;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()) return s;
        
        int top= s.pop();
        
        sort(s);
        
        insert(s,top);
        
        return s;
    }
    
    void insert(Stack<Integer> s, int ele){
        if(s.isEmpty() || ele>s.peek()){
            s.push(ele);
            return;
        }
        
        int top= s.pop();
        insert(s, ele);
        
        s.push(top);
        
    }
}
