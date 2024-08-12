package Strings;

import java.util.*;

public class IsAnagram {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m) return false;

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for(int i = 0; i < n; i++){
            mp1.put(s.charAt(i), mp1.getOrDefault(s.charAt(i), 0) + 1);
            mp2.put(t.charAt(i), mp2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(char c : mp1.keySet()){
            if(!mp1.get(c).equals(mp2.getOrDefault(c, 0))) return false;
        }

        return true;
    }
}

class Solution1 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
