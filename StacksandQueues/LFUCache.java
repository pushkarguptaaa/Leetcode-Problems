package StacksandQueues;

import java.util.*;

public class LFUCache {
    public static void main(String[] args) {
        
    }
}

class LFUCache1 {

    int capacity;
    int minfreq;
    int currsize;
    Map<Integer, Node> mp;
    Map<Integer, Dlist> fmp;

    public LFUCache1(int capacity) {
        this.capacity= capacity;
        this.minfreq= 0;
        this.currsize= 0;
        this.mp= new HashMap<>();
        this.fmp= new HashMap<>();
    }
    
    public int get(int key) {
        Node node= mp.get(key);
        if(node==null) return -1;
        updateNode(node);
        return node.val;
    }
    
    @SuppressWarnings("unlikely-arg-type")
    public void put(int key, int value) {
        if(capacity==0) return;

        if(mp.containsKey(key)){
            Node node= mp.get(key);
            node.val= value;
            updateNode(node);
        } else{
            currsize++;
            if(currsize>capacity){
                Dlist minflist= fmp.get(minfreq);
                mp.remove(minflist.tail.prev);
                minflist.remove(minflist.tail.prev);
                currsize--;
            }

            minfreq= 1;
            Node node= new Node(key,value);
            Dlist dlist = fmp.getOrDefault(1, new Dlist());
            dlist.insert(node);
            fmp.put(1, dlist);
            mp.put(key,node); 
        }
    }

    void updateNode(Node node){
        int currfreq= node.freq;
        Dlist dlist= fmp.get(currfreq);
        dlist.remove(node);

        if(currfreq==minfreq && dlist.lsize==0) minfreq++;

        node.freq++;
        Dlist newlist= fmp.getOrDefault(node.freq, new Dlist());
        newlist.insert(node);
        fmp.put(node.freq, newlist);
    }

    class Node{
        Node prev, next;
        int key, val, freq;

        Node(int key, int val){
            this.key= key;
            this.val= val;
            this.freq= 1;
        }
    }

    class Dlist{
        Node head, tail;
        int lsize;
        
        Dlist(){
            this.head= new Node(0,0);
            this.tail= new Node(0,0);
            this.lsize= 0;
            this.head.next= tail;
            this.tail.prev= head;
        }

        void insert(Node node){
            mp.put(node.key,node);
            node.next= head.next;
            head.next.prev= node;
            head.next= node;
            node.prev= head;
            lsize++;
        }

        void remove(Node node){
            mp.remove(node.key);
            node.prev.next= node.next;
            node.next.prev= node.prev;
            lsize--;
        }

    }
}
