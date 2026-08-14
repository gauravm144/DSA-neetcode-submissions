class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        find(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    void find(int[] nums, int idx,
              List<Integer> tmp, List<List<Integer>> ans) {

        // current subset is always valid
        ans.add(new ArrayList<>(tmp));

        for (int i = idx; i < nums.length; i++) {

            // skip duplicate at the same level
            if (i > idx && nums[i] == nums[i - 1])
                continue;

            // choose
            tmp.add(nums[i]);

            find(nums, i + 1, tmp, ans);

            // backtrack
            tmp.remove(tmp.size() - 1);
        }
    }
}