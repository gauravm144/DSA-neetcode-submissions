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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        while(head!=null){
            int sz=k;
            ListNode start=head,end=null;
            while(sz!=0&&head!=null){
                sz--;
                end=head;
                head=head.next;
            }
            end.next=null;
            if(sz==0)
            ans.next=rev(start);
            else
            ans.next=start;
            while(ans.next!=null)
            ans=ans.next;
        }
        return dummy.next;
    }
    ListNode rev(ListNode tmp){
        ListNode prev=null,next=null;
        while(tmp!=null){
            next=tmp.next;
            tmp.next=prev;
            prev=tmp;
            tmp=next;
        }
        return prev;
    }
}
