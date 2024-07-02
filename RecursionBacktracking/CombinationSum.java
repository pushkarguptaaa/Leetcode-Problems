package RecursionBacktracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();

        findCombinations(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    void findCombinations(int ind, int [] nums, int target, List<Integer> res, List<List<Integer>> ans){
        if(ind==nums.length){
            if(target==0) ans.add(new ArrayList<>(res));
            
            return;
        }

        if(nums[ind]<=target){
            res.add(nums[ind]);
            findCombinations(ind, nums, target-nums[ind], res, ans);
            res.remove(res.size()-1);
        }
        findCombinations(ind+1, nums, target, res, ans);
    }
}
