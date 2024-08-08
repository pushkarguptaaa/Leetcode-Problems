package Strings;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int cnt = 1;
        String s = a;

        while(s.length() < b.length()){
            s+= a;
            cnt++;
        }
        if(issubstr(b, s)) return cnt;
        if(issubstr(b, s + a)) return cnt + 1;

        return -1;
    }

    boolean issubstr(String a, String b){
        int m = a.length();
        int n = b.length();

        for(int i = 0; i <= n - m; i++){
            int j;
            for(j = 0; j < m; j++){
                if(b.charAt(i + j) != a.charAt(j)) break;
            }
            if(j == m) return true;
        }
        return false;
    }
}

