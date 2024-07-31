package StacksandQueues;

import java.util.*;

public class MinStack {
    public static void main(String[] args) {
        
    }
}

class MinStack1 {
    Stack<Pair> st;

    public MinStack1() {
        st= new Stack<>();
    }
    
    public void push(int val) {
        int min= Integer.MAX_VALUE;
        if(st.isEmpty()) min= val;
        else min= Math.min(val, st.peek().y);

        st.push(new Pair(val,min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().y;
    }
}

class Pair{
        int x,y;

        Pair(int x, int y){
            this.x= x;
            this.y= y;
        }
}

class MinStack2 {
    Stack<Integer> st;
    int min;
    public MinStack2() {
        st= new Stack<>();
        min= Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            min= val;
            st.push(val);
        }
        else{
            if(val<min){
                st.push(2*val-min);
                min= val;
            } else st.push(val);
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int val= st.pop();
        if(val<min) min= 2*min-val;
    }
    
    public int top() {
        int val= st.peek();
        if(val<min) return min;
        return val;
    }
    
    public int getMin() {
        return min;
    }
}




