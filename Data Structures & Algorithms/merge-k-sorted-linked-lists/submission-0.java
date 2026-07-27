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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        for(int i=0;i<lists.length;i++){
            q.offer(lists[i]);
        }
        while(!q.isEmpty()){
            ListNode tmp=q.poll();
            ans.next=tmp;
            ans=ans.next;
            if(tmp.next!=null)
            q.offer(tmp.next);
        }
        return dummy.next;
    }
}
