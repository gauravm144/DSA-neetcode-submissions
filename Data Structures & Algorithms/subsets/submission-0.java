class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> tmp=new ArrayList<>();
    getall(tmp,ans,nums,0);
    return ans;    
    }
    void getall(List<Integer> tmp,List<List<Integer>> ans,int[] nums,int start){
        if(start==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[start]);
        getall(tmp,ans,nums,start+1);
        tmp.remove(tmp.size()-1);
        getall(tmp,ans,nums,start+1);

    }
}
