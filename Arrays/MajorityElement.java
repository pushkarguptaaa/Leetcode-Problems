package Arrays;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int i=0; i<n; i++){
            int value= hm.getOrDefault(nums[i], 0);
            hm.put(nums[i], value+1);
        }

        for(Map.Entry<Integer, Integer>  entry: hm.entrySet()){
            if(entry.getValue()> n/2) return entry.getKey();
        }

        return -1;
    }
}

class Solution1 {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int ele= 0;
        int cnt= 0;

        for(int i=0; i<n; i++){
            if(cnt==0){
                ele= nums[i];
                cnt= 1;
            }
            else if(nums[i]==ele) cnt++;
            else cnt--;
        }

        int cnt1= 0;

        for(int i=0; i<n; i++){
            if(nums[i]==ele) cnt1++;
        }

        if(cnt1>n/2) return ele;

        return -1;
    }
}
