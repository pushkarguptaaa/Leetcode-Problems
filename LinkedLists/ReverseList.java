package LinkedLists;

import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode child;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     ListNode(int val, ListNode next, ListNode child) { this.val = val; this.next = next; this.child = child; }
 }


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp= head;
        Stack<Integer> st= new Stack<>();

        while(temp!=null){
            st.push(temp.val);
            temp= temp.next;
        }
        temp= head;
        while(temp!=null){
            temp.val= st.pop();
            temp= temp.next;
        }
        return head;
    }
}

class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode temp= head;
        ListNode prev= null;

        while(temp!=null){
            ListNode front= temp.next;
            temp.next= prev;
            prev= temp;
            temp= front;
        }
        return prev;
    }
}

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode newHead= reverseList(head.next);
        ListNode front= head.next;
        front.next= head;
        head.next= null;

        return newHead;
    }

}