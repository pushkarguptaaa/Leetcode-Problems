package LLAndArrays;

class ListNode {
    int val;
    ListNode next;
    ListNode child;
    ListNode random;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RotateRight {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;

        for(int i=0; i<k; i++){
            ListNode temp= head;
            while(temp.next.next!=null){
                temp= temp.next;
            }
            ListNode end= temp.next;
                end.next= head;
                temp.next= null;
                head= end;
        }
        return head;
    }
}

class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode temp= head;
        int l= 1;
        while(temp.next!=null){
            l++;
            temp= temp.next;
        }

        temp.next= head;
        k= k%l;
        k= l-k;

        while(k>0){
            temp= temp.next;
            k--;
        }
        
        head= temp.next;
        temp.next= null;
        
        return head;
    }
}
