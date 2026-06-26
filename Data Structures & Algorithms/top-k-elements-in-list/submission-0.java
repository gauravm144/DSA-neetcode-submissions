class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] data = new ArrayList[nums.length + 1]; //array of list

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (data[freq] == null)
                data[freq] = new ArrayList<>();

            data[freq].add(num);
        }

        int[] ans=new int[k];
        int index = 0;
        for (int i = data.length - 1; i >= 0 && index < k; i--) {
            if (data[i] != null) {
                for (int num : data[i]) {
                    ans[index++] = num;
                    if (index == k)
                        break;
                }
            }
        }
        return ans;
    }
}
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
