package Strings;

public class IndexSubstring {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(needle == null || m == 0) return 0;

        for(int i = 0; i <= n-m; i++){
            int j;
            for(j = 0; j < m; j++){
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if(j == m) return i;
        }
        return -1;
    }
}

class Solution1 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(needle == null || m == 0) return 0;

        int[] lps = new int[m];
        int prev = 0;
        int i = 1;

        while(i < m){
            if(needle.charAt(i) == needle.charAt(prev)){
                lps[i] = prev + 1;
                prev++;
                i++;
            }
            else if(prev == 0){
                lps[i] = 0;
                i++;
            }
            else{
                prev = lps[prev - 1];
            }
        }

        i = 0;
        int j = 0;

        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else if(j == 0) i++;
            else j = lps[j - 1];

            if(j == m) return i - m;
        }
        return -1;
    }
}


