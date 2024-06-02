package Arrays;

import java.util.*;

public class MergeSortedArrays {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left= m-1;
        int right= 0;

        while(left>=0 && right<n){
            if(nums1[left]>nums2[right]){
                int temp= nums1[left];
                nums1[left]= nums2[right];
                nums2[right]= temp;

                left--;
                right++;
            } else break;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}

class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int j=0, i=m; j<n; j++){
            nums1[i]= nums2[j];
            i++;
        }

        Arrays.sort(nums1);
    }
}


