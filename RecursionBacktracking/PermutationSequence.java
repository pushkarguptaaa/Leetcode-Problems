package RecursionBacktracking;

import java.util.*;

public class PermutationSequence {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String getPermutation(int n, int k) {
        List<String> ans= new ArrayList<>();
        String s= "";
        for(int i=1; i<=n; i++){
            s+=i;
        }
        permutationsHelper(0, s.toCharArray(), ans);
        
        Collections.sort(ans);

        return ans.get(k-1);
    }

    void permutationsHelper(int ind, char s[],  List<String> ans){
        if(ind==s.length){
            ans.add(new String(s));

            return;
        }

        for(int i=ind; i<s.length; i++){
            swap(s, i, ind);
            permutationsHelper(ind+1, s, ans);
            swap(s, i, ind);
        }
    }

    void swap(char s[], int i, int j){
        char temp= s[i];
        s[i]= s[j];
        s[j]= temp;
    }
}

class Solution1 {
    public String getPermutation(int n, int k) {
        int fact= 1;
        List<Integer> res= new ArrayList<>();

        for(int i=1; i<n; i++){
            fact*= i;
            res.add(i);
        }
        res.add(n);

        String ans= "";
        k--;

        while(true){
            ans+= res.get(k/fact).toString();
            res.remove(k/fact);
            if(res.size()==0) break;

            k= k%fact;
            fact= fact/res.size();
        }
        return ans;
    }
}