class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++)
        q.offer(stones[i]);
        while(q.size()>=2){
            int a=q.poll();
            int b=q.poll();
            if(a!=b)
            q.offer(Math.abs(a-b));
        }
        return q.isEmpty()?0:q.poll();
    }
}
