class Pair{
    int val;
    int pos;
    public Pair(int val,int pos){
        this.val=val;
        this.pos=pos;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> q=new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
        int i=0;
        int j=0;
        int[] ans=new int[nums.length-k+1];
        while(i<k-1){
            q.offer(new Pair(nums[i],i));
            i++;
        }
        while(i<nums.length){
            q.offer(new Pair(nums[i],i));
            while(i-q.peek().pos>k-1)
                q.poll();
            ans[j++]=q.peek().val;
            i++;
        }

        return ans;
    }
}
// Add current element
//         ↓
// Heap ka top dekho
//         ↓
// Top outdated?
//       /    \
//     Yes     No
//     ↓        ↓
//   poll()   Answer = top.val
//     ↓
// Phir se top check karo