package Strings;

public class LongestPalindrome {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String longestPalindrome(String s) {
        String res= "";
        int maxlen= 0;
        int n= s.length();

        for(int i=0; i<n; i++){
            int l = i;
            int r = i;

            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1>maxlen){
                    res= s.substring(l,r+1);
                    maxlen= r-l+1;
                }
                l--;
                r++;
            }
            l= i;
            r= i+1;

            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1>maxlen){
                    res= s.substring(l,r+1);
                    maxlen= r-l+1;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
