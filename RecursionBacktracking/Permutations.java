package RecursionBacktracking;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        boolean freq[]= new boolean[nums.length];

        recPermute(0, nums, new ArrayList<>(), freq, ans);

        return ans;
    }

    void recPermute(int ind, int[] nums, List<Integer> res, boolean[] freq, List<List<Integer>> ans){
        if(res.size()==nums.length){
            ans.add(new ArrayList<>(res));

            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i]= true;
                res.add(nums[i]);
                recPermute(i, nums, res, freq, ans);
                res.remove(res.size()-1);
                freq[i]= false;
            }
        }
    }
}

class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        recPermute(0, nums, ans);

        return ans;
    }

    void recPermute(int ind, int[] nums,  List<List<Integer>> ans){
        if(ind==nums.length){
            List<Integer> res= new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                res.add(nums[i]);
            }

            ans.add(new ArrayList<>(res));

            return;
        }

        for(int i=ind; i<nums.length; i++){
            swap(nums, ind, i);
            recPermute(ind+1, nums, ans);
            swap(nums, ind, i);
        }
    }

    void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}
