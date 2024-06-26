package LinkedLists;

public class Add2Numbers {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dNode= new ListNode(-1);
        ListNode temp= dNode;
        int carry= 0;

        while(l1!=null || l2!=null || carry==1){
            int sum= 0;
            if(l1!=null){
                sum+= l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                sum+= l2.val;
                l2= l2.next;
            }

        sum+= carry;
        carry= sum/10;
        temp.next= new ListNode(sum%10);
        temp= temp.next;
        }

        return dNode.next;

    }
}
