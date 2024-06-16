package LinkedLists;

import java.util.*;

public class Merge2Lists {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> arr= new ArrayList<>();
        ListNode temp1= list1;
        ListNode temp2= list2;

        while(temp1!=null){
            arr.add(temp1.val);
            temp1= temp1.next;
        }
        while(temp2!=null){
            arr.add(temp2.val);
            temp2= temp2.next;
        }
        Collections.sort(arr);
        ListNode head= convertArrToLinkedList(arr);

        return head;
    }

    public ListNode convertArrToLinkedList(List<Integer> arr){
        int n= arr.size();
        ListNode dNode= new ListNode(-1);
        ListNode temp= dNode;

        for(int i=0; i<n; i++){
            temp.next= new ListNode(arr.get(i));
            temp= temp.next;
        }
        return dNode.next;
    }
}

class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dNode= new ListNode(-1);
        ListNode temp= dNode;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next= list1;
                list1= list1.next;
            }
            else{
                temp.next= list2;
                list2= list2.next;
            }

            temp= temp.next;
        }

        if(list1!=null) temp.next= list1;
        else temp.next= list2;

        return dNode.next;
    }
}