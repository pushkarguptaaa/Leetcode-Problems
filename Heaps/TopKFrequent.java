package Heaps;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp= new HashMap<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>();

        for(int num: nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k) pq.poll();
        }

        int[] ans= new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i]= pq.poll().val;
        }
        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int val, freq;

    Pair(int val, int freq){
        this.val= val;
        this.freq= freq;
    }

    public int compareTo(Pair p){
        return this.freq-p.freq;
    }
}
