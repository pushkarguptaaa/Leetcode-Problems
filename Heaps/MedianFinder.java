package Heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> sHeap, lHeap;
    public MedianFinder() {
        sHeap= new PriorityQueue<>((a,b)->b-a);
        lHeap= new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        sHeap.add(num);
        if(sHeap.size()-lHeap.size()>1 || !lHeap.isEmpty() && sHeap.peek()>lHeap.peek()){
            lHeap.add(sHeap.poll());
        }
        if(lHeap.size()-sHeap.size()>1){
            sHeap.add(lHeap.poll());
        }
    }
    
    public double findMedian() {
        if(sHeap.size()==lHeap.size()) return (double)(sHeap.peek()+lHeap.peek())/2.0;
        else if(sHeap.size()>lHeap.size()) return sHeap.peek();
        else return lHeap.peek();
    }
}
