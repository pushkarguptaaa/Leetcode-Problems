package GreedyAlgorithm;

import java.util.*;

public class FindPlatform {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        int ans= 1;
        
        for(int i=0; i<n; i++){
            int cnt= 1;
            for(int j=i+1; j<n; j++){
                if(arr[i]>= arr[j] && arr[i]<=dep[j] || arr[j]>= arr[i] && arr[j]<=dep[i]){
                    cnt++;
                }
            }
            ans= Math.max(ans,cnt);
        }
        return ans;
    }
    
}

class Solution1
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans= 1;
        int plat= 1;
        int i= 1;
        int j= 0;
        
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                plat++;
                i++;
            }
            else if(arr[i]>dep[j]){
                plat--;
                j++;
            }
            
            ans= Math.max(ans,plat);
        }
        
        return ans;
        
    }
    
}
