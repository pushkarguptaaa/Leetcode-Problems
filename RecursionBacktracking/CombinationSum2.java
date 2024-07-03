package RecursionBacktracking;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> st= new HashSet<>();
        List<List<Integer>> ans= new ArrayList<>();

        findCombinations(0, candidates, target, new ArrayList<>(), st);

        for(List<Integer> list: st){
            ans.add(list);
        }

        return ans;
    }

    void findCombinations(int ind, int[] nums, int target, List<Integer> res, Set<List<Integer>> st){
        if(ind==nums.length){
            if(target==0) st.add(new ArrayList<>(res));

            return;
        }

        if(nums[ind]<=target){
            res.add(nums[ind]);
            findCombinations(ind+1, nums, target-nums[ind], res, st);
            res.remove(res.size()-1);
        }
        findCombinations(ind+1, nums, target, res, st);
    }
}

class Solution1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();

        findCombinations(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    void findCombinations(int ind, int[] nums, int target, List<Integer> res, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=ind; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            if(target<0) break;

            res.add(nums[i]);
            findCombinations(i+1, nums, target-nums[i], res, ans);
            res.remove(res.size()-1);
        }
    }
}
