package Arrays;

import java.util.*;

public class RepeatedNumber {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ArrayList<Integer> repeatedNumber(List<Integer> A) {
        int n= A.size();
        ArrayList<Integer> ans= new ArrayList<>();
        int[] freq= new int[n+1];
        
        for(int i=0; i<n; i++){
            freq[A.get(i)]++;
        }
        
        int missing= -1;
        int repeating= -1;
        
        for(int i=1; i<=n; i++){
            if(freq[i]==0) missing= i;
            if(freq[i]==2) repeating= i;
            
            if(missing!=-1 && repeating!=-1) break;
        }
        
        ans.add(repeating);
        ans.add(missing);
        
        return ans;
    }
}

class Solution1 {
    public ArrayList<Integer> repeatedNumber(List<Integer> A) {
        int n= A.size();
        ArrayList<Integer> ans= new ArrayList<>();
        long Sn= (long)(n*(n+1))/2;
        long S2n= (long)(n*(n+1)*(2*n+1))/6;
        long S= 0;
        long S2= 0;
        
        for(int i=0; i<n; i++){
            S+= (long)A.get(i);
            S2+= (long)A.get(i)* (long)A.get(i);
        }
        
        long eq1= S-Sn;
        long eq2= S2-S2n;
        eq2= eq2/eq1;
        long x= (eq1+eq2)/2;
        long y= x-eq1;
        
        ans.add((int)x);
        ans.add((int)y);
        
        return ans;
    }
}


