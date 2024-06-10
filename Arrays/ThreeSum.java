package Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st= new HashSet<>();
        int n= nums.length;

        for(int i=0; i<n; i++){
            HashSet<Integer> hs= new HashSet<>();

            for(int j=i+1; j<n; j++){
                int third= -(nums[i]+nums[j]);

                if(hs.contains(third)){
                    List<Integer> ls= Arrays.asList(nums[i],nums[j],third);
                    ls.sort(null);
                    st.add(ls);
                }
                else{
                    hs.add(nums[j]);
                }
            }
        }

        List<List<Integer>> ans=  new ArrayList<>(st);

        return ans;
    }
}

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);


        for(int i=0; i<n; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int j= i+1;
            int k= n-1;

            while(j<k){
                int sum= nums[i]+nums[j]+nums[k];

                if(sum>0) k--;
                else if(sum<0) j++;
                else{
                    List<Integer> ls= Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(ls);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }

        }

        return ans;
    }
}
