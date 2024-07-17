package Heaps;

public class ImplementHeap {
    public static void main(String[] args) {
        
    }
}

class Solution {

    public void maxHeap(int n, int[] a) {
        for(int i= n/2; i>0; i--){
            heapify(n, a, i);
        }
    }

    void heapify(int n, int[] a, int i){
        int largest= i;
        int lc= 2*n;
        int rc= lc+1;

        if(lc>largest) largest= lc;
        if(rc>largest) largest= rc;

        if(largest!=i){
            swap(a, largest, i);
            heapify(n, a, largest);
        }
    }

    void swap(int[] a, int i, int j){
        int temp= a[i];
        a[i]= a[j];
        a[j]= temp;
    }
}

class Solution1 {

    public void heapSort(int n, int[] a) {
        // maxHeap(n, a);
        for(int i= n; i<1; i--){
            // swap(a, i, 1);
            // heapify(n, a, i-1);
        }
    }
}

