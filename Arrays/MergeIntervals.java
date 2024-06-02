package Arrays;

import java.util.*;;

public class MergeIntervals {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int n= intervals.length;

        List<int[]> ans= new ArrayList<>(); 

        for(int i=0; i<n; i++){
            int start= intervals[i][0];
            int end= intervals[i][1];

            if(!ans.isEmpty() && end<= ans.get(ans.size()-1)[1])
                continue;
            
            for(int j=i+1; j<n; j++){
                if(intervals[j][0]<= end){
                    end= Math.max(end, intervals[j][1]);
                } else break;
            }
            ans.add(new int[]{start, end});

        }

        return ans.toArray(new int[ans.size()][]);
    }
}

class Solution1 {
    public int[][] merge(int[][] intervals) {
        int n= intervals.length;
        List<int[]> ans= new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for(int i=0; i<n; i++){
            int start= intervals[i][0];
            int end= intervals[i][1];
            if(ans.isEmpty() || start> ans.get(ans.size()-1)[1]){
                ans.add(new int[]{start, end});
            }
            else{
                ans.get(ans.size()-1)[1]= Math.max(end, ans.get(ans.size()-1)[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

