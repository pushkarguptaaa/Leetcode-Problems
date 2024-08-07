package Strings;

public class MyAtoi {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length()==0) return 0;

        int n = s.length();
        int i = 0;
        int sign= 1;

        while(i<n && s.charAt(i)==' '){
            i++;
        }

        if(i==n) return 0;

        char char1 = s.charAt(i);
        if(char1 == '-' || char1 == '+'){
            sign = (s.charAt(i)=='-') ? -1 : 1;
            i++;
        }
        

        int res = 0;
        while(i<n){
            char ch = s.charAt(i);
            
            if(ch<'0' || ch>'9') break;

            if(res > (Integer.MAX_VALUE - (ch - '0'))/10){
                return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res= (res*10)+(ch-'0');
            i++;
        }
        return sign * res;
    }
}
