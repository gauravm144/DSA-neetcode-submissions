class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        getall(ans,tmp,nums,target,0,0);
        return ans;
    }
    void getall(List<List<Integer>> ans,List<Integer> tmp,int[] nums,int target,int cursum,int pos){
        if(target==cursum){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(target<cursum)
        return;
        if(pos==nums.length)
        return;

        tmp.add(nums[pos]);
        getall(ans,tmp,nums,target,cursum+nums[pos],pos);
        tmp.remove(tmp.size()-1);
        getall(ans,tmp,nums,target,cursum,pos+1);
    }
}
