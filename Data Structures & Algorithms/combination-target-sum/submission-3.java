class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        find(nums, 0, new ArrayList<>(), ans, target);
        return ans;
    }
    void find(int[] nums, int idx, List<Integer> tmp, List<List<Integer>> ans, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            find(nums, i, tmp, ans, target - nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}