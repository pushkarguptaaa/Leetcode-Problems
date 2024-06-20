package LinkedLists;

import java.util.*;

public class IsPalindrome {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st= new Stack<>();
        ListNode temp= head;

        while(temp!=null){
            st.push(temp.val);
            temp= temp.next;
        }
        temp= head;

        while(temp!=null){
            if(temp.val!=st.peek()) return false;
            st.pop();
            temp= temp.next;
        }
        return true;
    }
}

class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow= head;
        ListNode fast= head;

        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode n= reverseList(slow.next);
        ListNode temp= head;

        while(n!=null){
            if(temp.val!=n.val){
                reverseList(n);
                return false;
            }
            n=n.next;
            temp= temp.next;
        }
        reverseList(n);
        return true;
    }

    public ListNode reverseList(ListNode head){
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
