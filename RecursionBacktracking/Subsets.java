package RecursionBacktracking;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> res= new ArrayList<>();

        subsetHelper(0,nums,res,ans);

        return ans;
    }

    void subsetHelper(int ind, int[] nums, List<Integer> res, List<List<Integer>> ans){
        if(ind==nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[ind]);
        subsetHelper(ind+1,nums,res,ans);
        res.remove(res.size()-1);
        subsetHelper(ind+1,nums,res,ans);
    }
}
