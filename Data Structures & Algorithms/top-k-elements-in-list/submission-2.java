class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

        List<Integer>[] bucket=new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> m:mp.entrySet()){
            int num=m.getKey();
            int freq=m.getValue();
            if(bucket[freq]==null)
            bucket[freq]=new ArrayList<>();
            bucket[freq].add(num);
        }
        int[] ans=new int[k];
        int index=0;
        for(int i=nums.length;i>=0&&index<k;i--){
            if(bucket[i]!=null){
                for(int j=0;j<bucket[i].size();j++)
                {ans[index++]=bucket[i].get(j);
                if(index==k)
                break;
                }
            }
        }
        return ans;
    }
}
// nlog n
// pehle map mai dalo value,freq
// fer map traverse krke array mai dalo pair value,freq, sort krdo aur first k lelo

// optimised using bucket sort o(n) spact o(n)
// Dry run

// For:

// nums = [1,1,1,2,2,3]
// k = 2

// HashMap

// 1 -> 3
// 2 -> 2
// 3 -> 1

// Buckets

// 0 -> null
// 1 -> [3]
// 2 -> [2]
// 3 -> [1]
// 4 -> null
// 5 -> null
// 6 -> null

// Now traverse from back:

// i = 6 -> null
// i = 5 -> null
// i = 4 -> null
// i = 3 -> [1]      ans = [1]
// i = 2 -> [2]      ans = [1,2]
// stop
// 4. Time Complexity
// Building map → O(n)
// Filling buckets → O(m) (m = distinct elements)
// Traversing buckets → O(n)

// Overall:

// O(n)

// Space:

// O(n)
