package LLAndArrays;

import java.util.*;

public class CopyRandomList {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode copyRandomList(ListNode head) {
        ListNode temp= head;
        Map<ListNode, ListNode> mp= new HashMap<>();

        while(temp!=null){
            ListNode copy= new ListNode(temp.val);
            mp.put(temp, copy);
            temp= temp.next;
        }

        temp= head;

        while(temp!=null){
            ListNode copy= mp.get(temp);
            copy.next= mp.get(temp.next);
            copy.random= mp.get(temp.random);
            temp= temp.next;
        }
        return mp.get(head);
    }
}

class Solutio1n {
    public ListNode copyRandomList(ListNode head) {
        ListNode temp= head;
        while(temp!=null){
            ListNode copy= new ListNode(temp.val);
            ListNode front= temp.next;
            copy.next= front;
            temp.next= copy;
            temp= front;
        }

        temp= head;

        while(temp!=null){
            ListNode copy= temp.next;
            if(temp.random!=null) copy.random= temp.random.next;
            else copy.random= null;
            temp= temp.next.next;
        }

        temp= head;
        ListNode dNode= new ListNode(-1);
        ListNode res= dNode;

        while(temp!=null){
            res.next= temp.next;
            res= res.next;
            temp.next= temp.next.next;
            temp= temp.next;
        }

        return dNode.next;
    }
}
