package GreedyAlgorithm;

import java.util.*;

public class MaxMeetings {
    public static void main(String[] args) {
        
    }
}

class meeting{
    int start;
    int end;
    int pos;
    
    meeting(int start, int end, int pos){
        this.start= start;
        this.end= end;
        this.pos= pos;
    }
}

class meetingComparator implements Comparator<meeting>{
    @Override
    public int compare(meeting m1, meeting m2){
        if(m1.end<m2.end) return -1;
        else if(m1.end>m2.end) return 1;
        else if(m1.pos<m2.pos) return -1;
        return 1;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meeting> meet= new ArrayList<>();
        for(int i=0; i<n; i++){
            meet.add(new meeting(start[i],end[i],i+1));
        }
        
        meetingComparator mc= new meetingComparator();
        Collections.sort(meet,mc);
        
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit= meet.get(0).end;
        
        for(int i=1; i<n; i++){
            if(meet.get(i).start>limit){
                limit= meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        return ans.size();
    }
}
