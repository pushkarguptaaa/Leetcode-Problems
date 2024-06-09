package Arrays;

import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n= nums.length;
        HashMap<Integer, Integer> hm= new HashMap<>();
        List<Integer> ls= new ArrayList<>();

        for(int i=0; i<n; i++){
            int val= hm.getOrDefault(nums[i], 0);
            hm.put(nums[i], val+1);

            if(hm.get(nums[i])>n/3 && !ls.contains(nums[i])) ls.add(nums[i]);

            if(ls.size()==2) break;
        }

        return ls;
    }
}

class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        int n= nums.length;
        int ele1= Integer.MIN_VALUE;
        int ele2= Integer.MIN_VALUE;
        int cnt1= 0;
        int cnt2= 0;
        List<Integer> ls= new ArrayList<>();

        for(int i=0; i<n; i++){
            if(cnt1==0 && nums[i]!=ele2){
                ele1= nums[i];
                cnt1= 1;
            }
            else if(cnt2==0 && nums[i]!=ele1){
                ele2= nums[i];
                cnt2= 1;
            }
            else if(nums[i]==ele1) cnt1++;
            else if(nums[i]==ele2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1= 0;
        cnt2= 0;

        for(int i=0; i<n; i++){
            if(ele1==nums[i]) cnt1++;
            if(ele2==nums[i]) cnt2++;
        }

        if(cnt1>n/3) ls.add(ele1);
        if(cnt2>n/3) ls.add(ele2);

        return ls;
    }
}
