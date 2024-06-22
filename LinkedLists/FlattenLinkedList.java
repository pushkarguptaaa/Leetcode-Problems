package LinkedLists;

import java.util.*;

public class FlattenLinkedList {
    public static void main(String[] args) {
        
    }
}

class Solution {

    public ListNode flattenLinkedList(ListNode head){
        List<Integer> arr= new ArrayList<>();
        ListNode temp= head;

        while(temp!=null){
            ListNode t2= temp;
            while(t2!=null){
                arr.add(t2.val);
                t2= t2.child;
            }
            temp= temp.next;
        }

        Collections.sort(arr);

        return convertToLinkedList(arr);   
    }

    public ListNode convertToLinkedList(List<Integer> arr){
        ListNode dNode= new ListNode(-1);
        ListNode temp= dNode;
        int n= arr.size();

        for(int i=0; i<n; i++){
            temp.child= new ListNode(arr.get(i));
            temp= temp.child;
        }
        return dNode.child;
    }
}

class Solution1 {

    public ListNode flattenLinkedList(ListNode head) {
        if(head==null  || head.next== null) return head;

        ListNode mergedHead= flattenLinkedList(head.next);
        head= merge(head, mergedHead);

        return head;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dNode= new ListNode(-1);
        ListNode temp= dNode;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.child= l1;
                temp= l1;
                l1= l1.child;
            }
            else{
                temp.child= l2;
                temp= l2;
                l2= l2.child;
            }
            temp.next= null;
        }

        if(l1!=null) temp.child= l1;
        else temp.child= l2;

        if(dNode.child!=null) dNode.child.next= null;

        return dNode.child;
    }
}


