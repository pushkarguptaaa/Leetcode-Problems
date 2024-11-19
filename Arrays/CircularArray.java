package Arrays;

public class CircularArray {
    
}

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            int s = i;
            int f = i;
            boolean isfwd = nums[i] >= 0;

            if(!vis[i]) {
                while(true) {
                    s = nextind(nums, s, isfwd);
                    if(s == -1) break;

                    f = nextind(nums, f, isfwd);
                    if(f == -1) break;

                    f = nextind(nums, f, isfwd);
                    if(f == -1) break;

                    if(s == f) return true;

                    vis[s] = true;
                    vis[f] = true;
                }
            }
        }
        return false;
    }

    int nextind(int[] nums, int curr, boolean isfwd) {
        int n = nums.length;
        boolean dir = nums[curr] >= 0;

        if(dir != isfwd) return -1;

        int next = (curr + nums[curr]) % n;
        if(next < 0) next+= n;

        if(next == curr) return -1;

        return next;
    }
}
