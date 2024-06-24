package LLAndArrays;

public class TrapRainwater {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int trap(int[] height) {
        int res= 0;
        int n= height.length;

        for(int i=0; i<n; i++){
            int leftM= 0;
            int rightM= 0;
            int j=i;

            while(j>=0){
                leftM= Math.max(leftM, height[j]);
                j--;
            }
            j=i;

            while(j<n){
                rightM= Math.max(rightM, height[j]);
                j++;
            }
            res+= Math.min(leftM, rightM)-height[i];
        }
        return res;
    }
}

class Solution1 {
    public int trap(int[] height) {
        int n= height.length;
        int pref[]= new int[n];
        int suff[]= new int[n];

        pref[0]= height[0];
        for(int i=1; i<n; i++){
            pref[i]= Math.max(pref[i-1], height[i]);
        }
        
        suff[n-1]= height[n-1];
        for(int i=n-2; i>=0; i--){
            suff[i]= Math.max(suff[i+1], height[i]);
        }

        int res= 0;
        for(int i=0; i<n; i++){
            res+= Math.min(pref[i],suff[i])-height[i];
        }
        return res;
    }
}

class Solution2 {
    public int trap(int[] height) {
        int n= height.length;
        int left= 0;
        int right= n-1;
        int maxL= 0;
        int maxR= 0;
        int res= 0;

        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxL) maxL= height[left];
                else res+= maxL-height[left]; 
                left++;
            }
            else{
                if(height[right]>=maxR) maxR= height[right];
                else res+= maxR-height[right]; 
                right--;
            }
        }
        return res;
    }
}
