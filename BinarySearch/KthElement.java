package BinarySearch;

import java.util.*;

public class KthElement {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        ArrayList<Integer> arr3 = new ArrayList<>();

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a.get(i) < b.get(j)) arr3.add(a.get(i++));
            else arr3.add(b.get(j++));
        }

        while (i < m) arr3.add(a.get(i++));
        while (j < n) arr3.add(b.get(j++));

        return arr3.get(k - 1);
    }
}

class Solution1 {
    public int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        int ele = -1;
        int cnt = 0; 
       
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a.get(i) < b.get(j)) {
                if (cnt == k - 1) ele = a.get(i);
                cnt++;
                i++;
            } else {
                if (cnt == k - 1) ele = b.get(j);
                cnt++;
                j++;
            }
        }

        while (i < m) {
            if (cnt == k - 1) ele = a.get(i);
            cnt++;
            i++;
        }
        while (j < n) {
            if (cnt == k - 1) ele = b.get(j);
            cnt++;
            j++;
        }

        return ele;
    }
}

class Solution2 {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n>m) return kthElement(arr2, arr1, m, n, k);
        int left= k;
        int low= Math.max(0, k-m), high= Math.min(n, k);
        
        while(low<=high){
            int mid1= (low+high)/2;
            int mid2= left-mid1;
            
            int l1= (mid1>0)? arr1[mid1-1]: Integer.MIN_VALUE;
            int l2= (mid2>0)? arr2[mid2-1]: Integer.MIN_VALUE;
            int r1= (mid1<n)? arr1[mid1]: Integer.MAX_VALUE;
            int r2= (mid2<m)? arr2[mid2]: Integer.MAX_VALUE;
            
            if(l1<=r2 && l2<=r1) return (long)Math.max(l1,l2);
            else if(l1>r2) high= mid1-1;
            else low= mid1+1;
        }
        return -1;
    }
}