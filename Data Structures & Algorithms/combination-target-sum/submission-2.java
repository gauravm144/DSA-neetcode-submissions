class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        find(nums, 0, new ArrayList<>(), ans, target);
        return ans;
    }
    void find(int[] nums, int idx, List<Integer> tmp, List<List<Integer>> ans, int target) {
        if (idx == nums.length)
            return;
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // choose
        tmp.add(nums[idx]);
        find(nums, idx, tmp, ans, target - nums[idx]);
        tmp.remove(tmp.size() - 1);
        // skip
        find(nums, idx + 1, tmp, ans, target);
    }
}
