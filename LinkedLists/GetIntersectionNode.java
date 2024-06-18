package LinkedLists;

import java.util.*;

public class GetIntersectionNode {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA!=null){
            ListNode temp= headB;
            while(temp!=null){
                if(temp==headA) return headA;
                temp= temp.next;
            }
            headA= headA.next;
        }

        return null;
    }
}

class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> st= new HashSet<>();
        while(headA!=null){
            st.add(headA);
            headA= headA.next;
        }

        while(headB!=null){
            if(st.contains(headB)) return headB;
            headB= headB.next;
        }

        return null;
    }
}

class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1= headA;
        ListNode d2= headB;
        while(d1!=d2){
            d1= d1==null?headB:d1.next;
            d2= d2==null?headA:d2.next;
        }
        return d1;
    }
}
