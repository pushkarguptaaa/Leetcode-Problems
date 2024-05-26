package Arrays;

public class nextPermutation {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        int ind= -1;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                ind= i;
                break;
            }
        }

        if(ind==-1){
            reverse(nums, 0);
            return;
        }
        
        for(int i= n-1; i>ind; i--){
            if(nums[i]> nums[ind]){
                swap(nums,i , ind);
                break;
            }
        }

        reverse(nums, ind+1);

    }

    public void swap(int[] nums, int n1, int n2){
        int temp= nums[n1];
        nums[n1]= nums[n2];
        nums[n2]= temp;
    }

    public void reverse(int[] nums, int start){
        int end= nums.length;
        for(int i=start; i<end; i++){
            swap(nums, start, end-1);
            start++;
            end--;
        }
    }
}
