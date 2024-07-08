package RecursionBacktracking;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st= new HashSet<>(wordDict);
        return recHelper(0, s, st);
    }

    boolean recHelper(int ind, String s,  Set<String> st){
        if(ind== s.length()) return true;

        String str= "";
        for(int i=ind; i<s.length(); i++){
            str+= s.charAt(i);
            if(st.contains(str)){
                if(recHelper(i+1, s, st)) return true;
            }
        }
        return false;
    }
}

class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st= new HashSet<>(wordDict);
        Boolean dp[]= new Boolean[s.length()];
        return recHelper(0, s, st, dp);
    }

    boolean recHelper(int ind, String s,  Set<String> st,  Boolean dp[]){
        if(ind== s.length()) return true;

        if(dp[ind]!=null) return dp[ind];

        String str= "";
        for(int i=ind; i<s.length(); i++){
            str+= s.charAt(i);
            if(st.contains(str)){
                if(recHelper(i+1, s, st, dp)){
                    dp[i]= true;
                    return true;
                }
            }
        }
        dp[ind]= false;
        return false;
    }
}
