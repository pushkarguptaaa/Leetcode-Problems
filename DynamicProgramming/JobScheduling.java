package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i = 0; i < n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return h(0, jobs, dp);
    }

    int h(int i, int[][] jobs, int[] dp){
        if(i >= jobs.length) return 0;

        if(dp[i] != -1) return dp[i];

        int skip = h(i + 1, jobs, dp);

        int take = jobs[i][2];

        int next = find(jobs, i);

        if(next != -1){
            take += h(next, jobs, dp);
        }

        return dp[i] = Math.max(skip, take); 
    }

    int find(int[][] jobs, int i){
        int low = i + 1;
        int high = jobs.length - 1;
        int end = jobs[i][1];

        while(low <= high){
            int mid = (low + high) / 2;

            if(jobs[mid][0] >= end) high = mid - 1;
            else low = mid + 1;
        }

        return (low < jobs.length) ? low: -1;
    }
}
