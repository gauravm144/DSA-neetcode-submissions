class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        Arrays.sort(candidates);
        getall(ans,tmp,candidates,target,0,0);
        return ans;
    }
    void getall(List<List<Integer>> ans,List<Integer> tmp,int[] candidates,int target,int cursum,int idx){
        if(target==cursum){
            ans.add(new ArrayList<>(tmp));
            return;
        }
         if (cursum > target)
            return;

        for(int i=idx;i<candidates.length;i++){
            if(i>idx&&candidates[i]==candidates[i-1])
            continue;
        tmp.add(candidates[i]);
        getall(ans,tmp,candidates,target,cursum+candidates[i],i+1);
        tmp.remove(tmp.size()-1);
        }
    }
}
