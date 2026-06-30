// class Pair{
//     int val;
//     int pos;
//     public Pair(int val,int pos){
//         this.val=val;
//         this.pos=pos;
//     }
// }
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         PriorityQueue<Pair> q=new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
//         int i=0;
//         int j=0;
//         int[] ans=new int[nums.length-k+1];
//         while(i<k-1){
//             q.offer(new Pair(nums[i],i));
//             i++;
//         }
//         while(i<nums.length){
//             q.offer(new Pair(nums[i],i));
//             while(i-q.peek().pos>k-1)// jha mai current hu aur jo top ka h uske beech k-1 (coz of 0th index form) hoga to remove
//                 q.poll();
//             ans[j++]=q.peek().val;
//             i++;
//         }

//         return ans;
//     }
// }

// using max heap
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



// using dequeue
// Deque mein hum sirf un elements ko rakhte hain jo future ki kisi window mein maximum ban sakte hain.

// Agar current element chhota hai → usko bhi rakh lo. Ho sakta hai bade wale ke bahar jaane ke baad ye maximum ban jaye.
// Agar current element bada hai → peeche ke saare chhote elements hata do. Wo future mein kabhi maximum nahi banenge.
// Tumhari language mein 😄
// Deque mein indices increasing order mein hote hain. ✅
// Front hamesha current window ka strongest candidate hota hai. ✅
// Front window se bahar gaya? ➜ Hata do. ✅
// Current aaya:
// Agar peeche wale se bada hai ➜ peeche wale ki game over, hata do. ✅
// Agar chhota hai ➜ rehne do, ho sakta hai future mein bada bahar nikle aur ye maximum ban jaye. ✅
// Current ko last mein daal do. ✅
// Front hi answer hai. ✅
// Ek line mein monotonic deque:

// Deque mein sirf wahi elements rehte hain jo future ki kisi window mein maximum banne ke candidate hain.


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        int j = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove indices that are outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Window formed, record answer
            if (i >= k - 1) {
                ans[j++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}