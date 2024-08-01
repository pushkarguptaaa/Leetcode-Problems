package StacksandQueues;

import java.util.*;

public class StockSpanner {
    public static void main(String[] args) {
        
    }
}

class StockSpanner1 {
    List<Integer> res;
    public StockSpanner1() {
        res= new ArrayList<>();
    }
    
    public int next(int price) {
        res.add(price);
        int n= res.size();
        int cnt= 1;

        for(int i=n-2; i>=0; i--){
            if(res.get(i)<=price) cnt++;
            else break;
        }

        return cnt;
    }
}

class StockSpanner2 {
    int ind;
    Stack<Pair> st;
    public StockSpanner2() {
        ind= -1;
        st= new Stack<>();
    }
    
    public int next(int price) {
        ind++;
        int ans;

        while(!st.isEmpty() && st.peek().val<=price) st.pop();

        ans= ind- (st.isEmpty() ? -1 : st.peek().ind);

        st.push(new Pair(price,ind));

        return ans;
    }
}

class Pair{
    int val, ind;

    Pair(int val, int ind){
        this.val= val;
        this.ind= ind;
    }
}