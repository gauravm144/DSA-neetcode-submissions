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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode tmp=head;
        while(tmp!=null){
            count++;
            tmp=tmp.next;
        }
        count=count-n-1;
        if(count==-1)
        return head.next;

        tmp=head;
        while(count!=0){
            count--;
            tmp=tmp.next;
        }
        tmp.next=tmp.next.next;
        return head;
    }
}
