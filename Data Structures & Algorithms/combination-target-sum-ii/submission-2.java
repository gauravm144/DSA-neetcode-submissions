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
        if (idx == candidates.length)
            return;
        if (target < 0)
            return;

        tmp.add(candidates[idx]);
        find(candidates, idx + 1, target - candidates[idx], tmp, ans);
        tmp.remove(tmp.size() - 1);

        int nxt = idx + 1;
        while (nxt < candidates.length && candidates[nxt] == candidates[idx]) nxt++;

        find(candidates, nxt, target, tmp, ans);
    }
}
