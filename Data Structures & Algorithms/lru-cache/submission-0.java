class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
    public Node(){}
}
class LRUCache {
    Map<Integer,Node> mp;
    Node dummyhead;
    Node dummytail;
    int size;
    int maxsize;
    public LRUCache(int capacity) {
        mp=new HashMap<>();
        dummyhead=new Node();
        dummytail=new Node();
        dummyhead.next=dummytail;
        dummytail.prev=dummyhead;
        maxsize=capacity;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))
        return -1;
        movetohead(key);
        return dummyhead.next.val;
    }
    
    public void put(int key, int val) {
        if(mp.containsKey(key)){
            movetohead(key);
            dummyhead.next.val=val;
            return;
        }
        if(size==maxsize){
            removefromtail();
            addtohead(key,val);
            return;
        }
        addtohead(key,val);
        size++;
    }
    public void movetohead(int key){
        Node cur=mp.get(key);
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
        
        cur.prev=dummyhead;
        cur.next=dummyhead.next;
        dummyhead.next.prev=cur;

        dummyhead.next=cur;
    }
    public void removefromtail(){
        mp.remove(dummytail.prev.key);
        Node tmpprev=dummytail.prev;
        dummytail.prev=null;
        dummytail=tmpprev;
    }
    public void addtohead(int key,int val){
        Node node=new Node(key,val);
        mp.put(key,node);
        node.next=dummyhead.next;
        dummyhead.next=node;
        node.next.prev=node;
        node.prev=dummyhead;
    }
}
