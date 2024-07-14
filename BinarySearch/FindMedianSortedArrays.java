package BinarySearch;

import java.util.*;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2= nums2.length;
        int n= n1+n2;
        int i= 0;
        int j= 0;

        List<Integer> res= new ArrayList<>();

        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]) res.add(nums1[i++]);
            else res.add(nums2[j++]);
        }

        while(i<n1) res.add(nums1[i++]);
        while(j<n2) res.add(nums2[j++]);

        if(n%2==1) return res.get(n/2);

        return (double)(res.get(n/2)+res.get(n/2-1))/2.0;
    }
}

class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2= nums2.length;
        int n= n1+n2;
        int ind2= n/2;
        int ind1= ind2-1;
        int indel2= -1, indel1= -1;
        int i= 0, j= 0, cnt= 0;

        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                if(cnt==ind1) indel1= nums1[i];
                if(cnt==ind2) indel2= nums1[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==ind1) indel1= nums2[j];
                if(cnt==ind2) indel2= nums2[j];
                cnt++;
                j++;
            }
        }

        while(i<n1){
                if(cnt==ind1) indel1= nums1[i];
                if(cnt==ind2) indel2= nums1[i];
                cnt++;
                i++;
            }

        while(j<n2){
                if(cnt==ind1) indel1= nums2[j];
                if(cnt==ind2) indel2= nums2[j];
                cnt++;
                j++;
            }

        if(n%2==1) return (double)indel2;

        return (double)(indel1+indel2)/2.0;
    }
}

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2= nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);

        int n= n1+n2;
        int left= (n+1)/2;
        int low= 0;
        int high= n1;

        while(low<=high){
            int mid1= (low+high)/2;
            int mid2= left-mid1;
            int l1= (mid1>0)? nums1[mid1-1]: Integer.MIN_VALUE;
            int r1= (mid1<n1)? nums1[mid1]: Integer.MAX_VALUE;
            int l2= (mid2>0)? nums2[mid2-1]: Integer.MIN_VALUE;
            int r2= (mid2<n2)? nums2[mid2]: Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                if(n%2==1) return Math.max(l1,l2);
                else return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            } else if(l1>r2) high= mid1-1;
            else low= mid1+1;
        }
        return -1;
    }
}