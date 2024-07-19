package Heaps;

import java.util.*;

public class MaxCombinations {
    public static void main(String[] args) {
        
    }
}

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        ArrayList<Integer> ans= new ArrayList<>();
        ArrayList<Integer> res= new ArrayList<>();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                res.add(A[i]+B[j]);
            }
        }
        Collections.sort(res, (a,b)->b-a);
        
        for(int i=0; i<K; i++){
            ans.add(res.get(i));
        }
        return ans;
    }
}

class Solution1 {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        ArrayList<Integer> ans= new ArrayList<>();
        HashSet<String> st= new HashSet<>();
        pq.add(new Pair(A[N-1]+B[N-1], N-1, N-1));
        st.add((N-1)+ " "+ (N-1));
        
        while(!pq.isEmpty()){
            Pair curr= pq.poll();
            ans.add(curr.val);
            int x= curr.x, y= curr.y;
            if(ans.size()==K) break;
            
            if(x-1>=0 && !st.contains((x-1)+ " "+ y)){
                st.add((x-1)+ " "+ y);
                pq.add(new Pair(A[x-1]+B[y], x-1, y));
            }
            
            if(y-1>=0 && !st.contains(x+ " "+ (y-1))){
                st.add(x+ " "+ (y-1));
                pq.add(new Pair(A[x]+B[y-1], x, y-1));
            }
        }
        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int val, x, y;
    
    Pair(int val, int x, int y){
        this.val= val;
        this.x= x;
        this.y= y;
    }
    
    public int compareTo(Pair p){
        return p.val-this.val;
    }
}