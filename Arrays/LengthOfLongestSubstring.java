package Arrays;

import java.util.*;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        if(n==0) return 0;

        int ans= Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            Set<Character> se= new HashSet<>();
            for(int j=i; j<n; j++){
                if(se.contains(s.charAt(j))){
                    ans= Math.max(ans, j-i);
                    break;
                }

                se.add(s.charAt(j));
                
            }
        }
        return ans;
    }
}

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        if(n==0) return 0;
        int max= Integer.MIN_VALUE;
        int l= 0;
        Set<Character> se= new HashSet<>();

        for(int r=0; r<n; r++){
            if(se.contains(s.charAt(r))){
                while(l<r && se.contains(s.charAt(r))){
                    se.remove(s.charAt(l));
                    l++;
                }
            }
            se.add(s.charAt(r));
            max= Math.max(max, r-l+1);
        }
        return max;
    }
}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        if(n==0) return 0;
        int l= 0;
        int max= Integer.MIN_VALUE;
        Map<Character, Integer> mp= new HashMap<>();

        for(int r=0; r<n; r++){
            if(mp.containsKey(s.charAt(r))) l= Math.max(l, mp.get(s.charAt(r))+1);
            mp.put(s.charAt(r),r);
            max= Math.max(max, r-l+1);
        }
        return max;
    }
}
