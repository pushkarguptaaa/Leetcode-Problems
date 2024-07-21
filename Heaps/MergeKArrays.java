package Heaps;

import java.util.*;

public class MergeKArrays {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> ans= new ArrayList<>();
        
        for(int i=0; i<K; i++){
            for(int j=0; j<K; j++){
                ans.add(arr[i][j]);
            }
        }
        Collections.sort(ans);
        
        return ans;
    }
}

class Solution1
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> ans= new ArrayList<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        for(int i=0; i<K; i++){
            pq.add(new Pair(arr[i], 0));
        }
        
        while(!pq.isEmpty()){
            Pair curr= pq.poll();
            ans.add(curr.arr[curr.ind]);
            
            if(curr.ind+1<curr.arr.length){
                pq.add(new Pair(curr.arr, curr.ind+1));
            }
        }
        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int[] arr;
    int ind;
    
    Pair(int[] arr, int ind){
        this.arr= arr;
        this.ind= ind;
    }
    
    public int compareTo(Pair p){
        return this.arr[this.ind]-p.arr[p.ind];
    }
}
