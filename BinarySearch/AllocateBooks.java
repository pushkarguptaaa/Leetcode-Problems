package BinarySearch;

import java.util.*;

public class AllocateBooks {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int books(ArrayList<Integer> A, int B) {
        int n= A.size();
        if(B>n) return -1;
        
        int low= Collections.max(A);
        int high= A.stream().mapToInt(Integer::intValue).sum();
        
        for(int pages= low; pages<=high; pages++){
            if(cntStud(A, pages)==B) return pages;
        }
        return low;
    }
    
    int cntStud(ArrayList<Integer> A, int pages){
        int n= A.size();
        int stud= 1;
        int studPages= 0;
        
        for(int i=0; i<n; i++){
            if(studPages+ A.get(i)<=pages) studPages+=A.get(i);
            else{
                stud++;
                studPages= A.get(i);
            }
        }
        return stud;
    }
}

class Solution1 {
    public int books(ArrayList<Integer> A, int B) {
        int n= A.size();
        if(B>n) return -1;
        
        int low= Collections.max(A);
        int high= A.stream().mapToInt(Integer::intValue).sum();
        
        while(low<=high){
            int mid= (low+high)/2;
            int stud= cntStud(A, mid);
            if(stud>B) low= mid+1;
            else high= mid-1;
        }
        return low;
    }
    
    int cntStud(ArrayList<Integer> A, int pages){
        int n= A.size();
        int stud= 1;
        int studPages= 0;
        
        for(int i=0; i<n; i++){
            if(studPages+ A.get(i)<=pages) studPages+=A.get(i);
            else{
                stud++;
                studPages= A.get(i);
            }
        }
        return stud;
    }
}


