package StacksandQueues;

import java.util.*;

public class QueueUsingStack {
    public static void main(String[] args) {
        
    }
}

class MyQueue {
    Stack<Integer> st1,st2;

    public MyQueue() {
        st1= new Stack<>();
        st2= new Stack<>();
    }
    
    public void push(int x) {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);

        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

class MyQueue1 {
    Stack<Integer> st1, st2;

    public MyQueue1() {
        st1= new Stack<>();
        st2= new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }

        return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }

        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
