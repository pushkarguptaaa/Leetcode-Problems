package LinkedLists;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp= head;
        int cnt= 0;

        while(temp!=null){
            cnt++;
            temp= temp.next;
        }

        if(n==cnt){
            head= head.next;
            return head;
        }

        int res= cnt-n;
        temp= head;

        while(temp!=null){
            res--;
            if(res==0) break;
            temp= temp.next;
        }

        temp.next= temp.next.next;

        return head;

    }
}

class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow= head;
        ListNode fast= head;

        for(int i=0; i<n; i++){
            fast= fast.next;
        }

        if(fast==null){
            head= head.next;
            return head;
        }

        while(fast.next!=null){
            slow= slow.next;
            fast= fast.next;
        }

        slow.next= slow.next.next;

        return head;
    }
}
