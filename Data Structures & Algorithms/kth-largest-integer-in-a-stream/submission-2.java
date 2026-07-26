class KthLargest {
    PriorityQueue<Integer> q1=new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> q2=new PriorityQueue<>();
    int sz;
    public KthLargest(int k, int[] nums) {
        for(int i=0;i<nums.length;i++)
        q2.offer(nums[i]);

        while(q2.size()>k){
            q1.offer(q2.poll());
        }
        sz=k;
    }
    
    public int add(int val) {
        q2.offer(val);
        if(q2.size()>sz){
        q1.offer(q2.poll());
        }
        return q2.peek();
    }
}
