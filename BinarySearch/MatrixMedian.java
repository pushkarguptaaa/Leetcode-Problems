package BinarySearch;

import java.util.*;

public class MatrixMedian {
    public static void main(String[] args) {
        
    }
}

class Solution {
    int median(int matrix[][], int R, int C) {
        ArrayList<Integer> arr= new ArrayList<>();
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                arr.add(matrix[i][j]);        
            }
        }
        
        Collections.sort(arr);
        
        return arr.get((R*C)/2);
    }
}

class Solution1 {
    int median(int matrix[][], int R, int C) {
        int low= Integer.MAX_VALUE;
        int high= Integer.MIN_VALUE;
        
        for(int i=0; i<R; i++){
            low= Math.min(low, matrix[i][0]);
            high= Math.max(high, matrix[i][C-1]);
        }
        
        while(low<=high){
            int mid= (low+high)/2;
            int cnt= 0;
            
            for(int i=0; i<R; i++){
                cnt+= helper(matrix[i], R, C, mid);
            }
            
            if(cnt<=(R*C)/2) low= mid+1;
            else high= mid-1;
        }
        return low;
    }
    
    int helper(int row[], int R, int C, int mid){
        int l= 0;
        int h= row.length-1;
        
        while(l<=h){
            int md= (l+h)/2;
            if(row[md]<=mid) l= md+1;
            else h= md-1;
        }
        return l;
    }
}
