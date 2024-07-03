package RecursionBacktracking;

import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();

        partitionHelper(0, s, new ArrayList<>(), ans);

        return ans;
    }

    void partitionHelper(int ind, String s, List<String> res, List<List<String>> ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(res));

            return;
        }

        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                res.add(s.substring(ind, i+1));
                partitionHelper(i+1, s, res, ans);
                res.remove(res.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }

        return true;
    }
}
