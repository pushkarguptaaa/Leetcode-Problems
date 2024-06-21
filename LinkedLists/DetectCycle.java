package LinkedLists;

import java.util.*;

public class DetectCycle {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> st= new HashSet<>();
        ListNode temp= head;

        while(temp!=null){
            if(st.contains(temp)) return temp;
            st.add(temp);
            temp= temp.next;
        }
        return null;
    }
}

class Solution1 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;

        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;

            if(slow==fast){
                slow= head;
                while(slow!=fast){
                    slow= slow.next;
                    fast= fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}