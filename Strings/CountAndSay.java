package Strings;

public class CountAndSay {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        if(n == 2) return "11";

        String s = "11";

        for(int i = 3; i <= n; i++){
            String t = "";
            s += '&';
            int cnt = 1;
            for(int j = 1; j < s.length(); j++){
                if(s.charAt(j) != s.charAt(j - 1)){
                    t += Integer.toString(cnt);
                    t += s.charAt(j - 1);
                    cnt = 1;
                }
                else cnt++;
            }
            s = t;
        }
        return s;
    }
}
