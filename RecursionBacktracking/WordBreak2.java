package RecursionBacktracking;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> st= new HashSet<>(wordDict);

        return recHelper(0, s, st);
    }

    List<String> recHelper(int ind, String s, Set<String> st){
        List<String> ans= new ArrayList<>();
        if(ind== s.length()){
            ans.add("");
            return ans;
        }

        for(int i= ind+1; i<=s.length(); i++){
            String word= s.substring(ind, i);
            if(st.contains(word)){
                List<String> substr= recHelper(i, s, st);

                for(String sub: substr){
                    ans.add(word+ (sub.isEmpty()? "": " ")+ sub);
                }
            }
        }
        return ans;
    }
}

class Solution1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> st= new HashSet<>(wordDict);
        Map<Integer, List<String>> mp= new HashMap<>();

        return recHelper(0, s, st, mp);
    }

    List<String> recHelper(int ind, String s, Set<String> st, Map<Integer, List<String>> mp){
        List<String> ans= new ArrayList<>();

        if(mp.containsKey(ind)){
            return mp.get(ind);
        }

        if(ind== s.length()){
            ans.add("");
            return ans;
        }

        for(int i= ind+1; i<=s.length(); i++){
            String word= s.substring(ind, i);
            if(st.contains(word)){
                List<String> substr= recHelper(i, s, st, mp);
 
                for(String sub: substr){
                    ans.add(word+ (sub.isEmpty()? "": " ")+ sub);
                }
            }
        }
        mp.put(ind, ans);
        return ans;
    }
}
