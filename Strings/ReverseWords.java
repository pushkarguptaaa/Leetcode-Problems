package Strings;

public class ReverseWords {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public String reverseWords(String s) {
        int i= 0;
        int n= s.length();
        String res= new String();

        while(i<n){
            while(i<n && s.charAt(i)== ' ') i++;
            if(i>=n) break;

            int j= i+1;
            while(j<n && s.charAt(j)!= ' ') j++;

            String sub= s.substring(i,j);
            res= (res.length()==0) ? sub : sub + ' ' + res; 
            i= j+1;
        }
        return res;
    }
}
