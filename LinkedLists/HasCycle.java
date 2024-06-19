package LinkedLists;

import java.util.*;

public class HasCycle {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp= head;
        Set<ListNode> st= new HashSet<>();

        while(temp!=null){
            if(st.contains(temp)) return true;
            st.add(temp);
            temp= temp.next;
        }
        return false;
    }
}

class Solution1 {
    public boolean hasCycle(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;

        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}


