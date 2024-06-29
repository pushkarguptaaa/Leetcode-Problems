package GreedyAlgorithm;

import java.util.*;

public class JobScheduling {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int maxDeadline= 0;
        for(int i=0; i<n; i++){
            maxDeadline= Math.max(maxDeadline, arr[i].deadline);
        }
        
        int[] result= new int[maxDeadline];
        for(int i=0; i<maxDeadline; i++){
            result[i]= -1;
        }
        
        int cntJobs= 0;
        int maxProfit= 0;
        
        for(int i=0; i<n; i++){
            for(int j=arr[i].deadline-1; j>=0; j--){
                if(result[j]==-1){
                    result[j]= arr[i].id;
                    cntJobs++;
                    maxProfit+= arr[i].profit;
                    break;
                }
            }
        }
        int ans[]= new int[2];
        ans[0]= cntJobs;
        ans[1]= maxProfit;
        return ans;
    }
}


class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

