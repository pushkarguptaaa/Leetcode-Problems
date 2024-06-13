package Arrays;

import java.util.*;

public class SubarrayXOR {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n= A.size();
        int cnt= 0;
        
        for(int i=0; i<n; i++){
            int xor= 0;
            for(int j=i; j<n; j++){
                xor= xor^A.get(j);
                if(xor==B) cnt++;
            }
        }
        return cnt;
    }
}

class Solution1 {
    public int solve(ArrayList<Integer> A, int B) {
        int n= A.size();
        int xor= 0;
        int cnt= 0;
        Map<Integer, Integer> mp= new HashMap<>();
        mp.put(xor,1);
        
        for(int i=0; i<n; i++){
            xor= xor^A.get(i);
            
            cnt+= mp.getOrDefault(xor^B,0);
            
            mp.put(xor,mp.getOrDefault(xor,0)+1);
        }
        return cnt;
    }
}


