/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
        return l2;
        if(l2==null)
        return l1;

        int carry=0;
        ListNode dummy=new ListNode(-1);
        dummy.next=l1;
        ListNode prevl1=null,prevl2=null;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            l1.val=sum%10;
            carry=sum/10;
            prevl1=l1;
            prevl2=l2;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null){
            prevl1.next=l2;
            l1=l2;
        }
        while(l1!=null){
            int sum=l1.val+carry;
            l1.val=sum%10;
            carry=sum/10;
            prevl1=l1;
            l1=l1.next;
        }
        if(carry!=0){
            ListNode t=new ListNode(carry);
            prevl1.next=t;
        }
        return dummy.next;
        

    }
}
