package LinkedLists;

public class ReverseKGroup {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp= head;
        ListNode prev= null;

        while(temp!=null){
            ListNode Kth= getKthNode(temp, k);
            if(Kth==null){
                if(prev!=null) prev.next= temp;
                break;
            }

            ListNode nextNode= Kth.next;
            Kth.next= null;

            reverseList(temp);

            if(temp==head) head= Kth;
            else prev.next= Kth;

            prev= temp;
            temp= nextNode;

        }
        return head;
    }

    public ListNode getKthNode(ListNode head, int k){
        k-= 1;
        while(head!=null && k>0){
            k--;
            head= head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head){
        ListNode temp= head;
        ListNode prev= null;

        while(temp!=null){
            ListNode next= temp.next;
            temp.next= prev;
            prev= temp;
            temp= next;
        }
        return prev;
    }
}
