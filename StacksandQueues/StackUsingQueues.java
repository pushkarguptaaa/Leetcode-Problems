package StacksandQueues;

import java.util.*;

public class StackUsingQueues {
    public static void main(String[] args) {
        
    }
}

class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {
        q1= new LinkedList<>();
        q2= new LinkedList<>();
    }
    
    public void push(int x) {
        q2.add(x);

        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        Queue<Integer> temp= q1;
        q1= q2;
        q2= temp;
    }
    
    public int pop() {
        return q1.remove();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

class MyStack1 {
    Queue<Integer> q;

    public MyStack1() {
        q= new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);

        for(int i=0; i<q.size()-1; i++){
            q.add(q.remove());
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}