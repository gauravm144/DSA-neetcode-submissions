class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        find(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    void find(int[] candidates, int idx, int target, List<Integer> tmp, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0)
            return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1])
                continue;

            tmp.add(candidates[i]);
            find(candidates, i + 1, target - candidates[i], tmp, ans);
            tmp.remove(tmp.size() - 1);
        }
    }
}
