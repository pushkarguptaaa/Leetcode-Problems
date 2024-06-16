package LinkedLists;

public class MiddleNode {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode temp= head;
        int cnt= 0;

        while(temp!=null){
            cnt++;
            temp= temp.next;
        }

        int mid= (cnt/2)+1;
        temp= head;

        while(temp!=null){
            mid= mid-1;
            if(mid==0) break;

            temp= temp.next;
        }

        return temp;
    }
}

class Solution1 {
    public ListNode middleNode(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;

        while(fast!= null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
}
