/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=new Node(-1);
        Node ans=dummy;

        Node ptr=head;
        
        Map<Node,Node> mp=new HashMap<>();

        while(ptr!=null){
            Node tmp=new Node(ptr.val);
            mp.put(ptr,tmp);
            ans.next=tmp;
            ans=ans.next;
            ptr=ptr.next;
        }
        ptr=head;
        ans=dummy.next;
        while(ptr!=null){
            ans.random=mp.get(ptr.random);
            ptr=ptr.next;
            ans=ans.next;
        }
        return dummy.next;
    }
}
