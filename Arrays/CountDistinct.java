package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinct {
    
}

class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < k; i++){
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);
        }
        
        ans.add(mp.size());
        
        for(int i = k; i < n; i++){
            if(mp.get(A[i - k]) == 1) mp.remove(A[i - k]);
            
            else mp.put(A[i - k], mp.get(A[i - k]) - 1);
            
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);
            ans.add(mp.size());
        }
        return ans;
    }
}
