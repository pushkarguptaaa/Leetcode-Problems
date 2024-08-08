package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs == null || strs.length == 0) return res;

        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);

            for(int s = 0; s < strs.length; s++){
                if(i == strs[s].length() || strs[s].charAt(i) != c) return res;
            }
            res+= c;
        }
        return res;
    }
}
