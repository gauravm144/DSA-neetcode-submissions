class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        find(nums, 0, nums.length, new ArrayList<>(), ans);
        return ans;
    }
    void find(int[] nums, int idx, int n, List<Integer> tmp, List<List<Integer>> ans) {
        if (idx == n) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // skip dup
        int nxt=idx+1;
        while(nxt<n&&nums[idx]==nums[nxt])
        nxt++;

        // donot choose
        find(nums, nxt, n, tmp, ans);
        // choose
        tmp.add(nums[idx]);
        find(nums, idx + 1, n, tmp, ans);
        tmp.remove(tmp.size() - 1);
    }
}
            //              []
            //         /          \
            //  DON'T 1          CHOOSE 1
            //      |                 |
            //      |                [1]
            //      |              /     \
            //      |        DON'T 1    CHOOSE 1
            //      |            |           |
            //      |          [1]        [1,1]
            //      |          / \          / \
            //      |        2?   2       2?   2
            //      |         |     |      |     |
            //      |        [1] [1,2] [1,1] [1,1,2]
            //      |
            //     idx=2
            //     /   \
            //   don't choose 2
            //      []
            //   choose 2
            //      [2]
