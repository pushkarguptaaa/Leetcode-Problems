package RecursionBacktracking;

import java.util.*;

public class Subsets2 {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> st= new HashSet<>();
        List<List<Integer>> ls= new ArrayList<>();
        Arrays.sort(nums);
        
        subsetHelper(0,nums,new ArrayList<>(),st);

        for(List<Integer> list: st){
            ls.add(list);
        }

        return ls;
    }

    void subsetHelper(int ind, int[] nums, List<Integer> res, Set<List<Integer>> st){
        if(ind==nums.length){
            st.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[ind]);
        subsetHelper(ind+1,nums,res,st);
        res.remove(res.size()-1);
        subsetHelper(ind+1,nums,res,st);
    }
}

class Solution1{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();

        subsetHelper(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    void subsetHelper(int ind, int[] nums, List<Integer> res,  List<List<Integer>> ans){
        ans.add(new ArrayList<>(res));

        for(int i=ind; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
                res.add(nums[i]);
                subsetHelper(i+1,nums,res,ans);
                res.remove(res.size()-1);
        }
    }
}
