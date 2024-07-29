package StacksandQueues;

import java.util.*;

public class LRUCache1 {
    public static void main(String[] args) {
        
    }
}

class LRUCache {
    Node head= new Node(0,0);
    Node tail= new Node(0,0);
    int capacity1;
    Map<Integer, Node> mp= new HashMap<>();

    public LRUCache(int capacity) {
        capacity1= capacity;
        head.next= tail;
        tail.prev= head;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node= mp.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) remove(mp.get(key));
        if(mp.size()==capacity1) remove(tail.prev);
        insert(new Node(key, value));
    }

    void remove(Node node){
        mp.remove(node.key);
        node.prev.next= node.next;
        node.next.prev= node.prev;
    }

    void insert(Node node){
        mp.put(node.key, node);
        node.next= head.next;
        head.next.prev= node;
        head.next= node;
        node.prev= head;
    }

    class Node{
    Node prev, next;
    int key, val;

    Node(int key, int val){
        this.key= key;
        this.val= val;
    }
}
}

