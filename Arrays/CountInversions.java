package Arrays;

import java.util.*;

public class CountInversions {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n-1);
    }

    public static long mergeSort(long arr[], int low, int high){
        long count= 0;
        if(low<high){
            int mid= (low+high)/2;
            count+= mergeSort(arr, low, mid);
            count+= mergeSort(arr, mid+1, high);

            count+= merge(arr, low, mid, high);
        }
         return count;
    }

    public static long merge(long arr[], int low, int mid, int high){
        List<Long> temp= new ArrayList<>();
        long count= 0;
        int left= low;
        int right= mid+1;

       while(left<=mid && right<=high){
           if(arr[left]<=arr[right]){
               temp.add(arr[left]);
               left++; 
           }
           else{
               temp.add(arr[right]);
               right++;
               count+= mid-left+1; 
           }
       }

       while(left<=mid){
           temp.add(arr[left]);
           left++;
       }
       while(right<=high){
           temp.add(arr[right]);
           right++;
       }

       for(int i=low; i<=high; i++){
           arr[i]= temp.get(i-low);
       }

       return count;
    }
    
}
