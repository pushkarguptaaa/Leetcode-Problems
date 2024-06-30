package GreedyAlgorithm;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        
    }
}

class Activity{
    int start;
    int end;
    
    Activity(int start, int end){
        this.start= start;
        this.end= end;
    }
}

class Solution
{
    public static int activitySelection(int start[], int end[], int n)
    {
        List<Activity> res= new ArrayList<>();
        for(int i=0; i<n; i++){
            res.add(new Activity(start[i],end[i]));
        }
        Collections.sort(res, (a,b)->a.end-b.end);
        int limit= res.get(0).end;
        
        int count= 1;
        
        for(int i=1; i<n; i++){
            if(res.get(i).start>limit){
                count++;
                limit= res.get(i).end;
            }
        }
        return count;
    }
}
