package Arrays;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n= nums.length;
        Set<List<Integer>> st= new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                Set<Long> hs= new HashSet<>();
                for(int k=j+1; k<n; k++){
                    long sum= nums[i]+nums[j];
                    sum+= nums[k];
                    long rqd= target-sum;

                    if(hs.contains(rqd)){
                        List<Integer> ls= Arrays.asList(nums[i],nums[j],nums[k],(int)rqd);
                        Collections.sort(ls);
                        st.add(ls);
                    }
                    else hs.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> ans= new ArrayList<>(st);
        return ans;
    }
}

class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        int n= nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k= j+1;
                int l= n-1;

                while(k<l){
                    long sum= nums[i];
                    sum+= nums[j];
                    sum+= nums[k];
                    sum+= nums[l];

                    if(sum==target){
                        List<Integer> ls= Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(ls);

                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(sum>target) l--;
                    else k++;
                }
            }
        }
        return ans;
    }
}
