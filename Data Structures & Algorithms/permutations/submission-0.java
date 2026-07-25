class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        call(ans,new ArrayList<>(),visited,nums);
        return ans;
    }
    void call(List<List<Integer>> ans,List<Integer> tmp,boolean[] visited,int[] nums){
        if(tmp.size()==nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i])
            continue;

            visited[i]=true;
            tmp.add(nums[i]);
            call(ans,tmp,visited,nums);

            visited[i]=false;
            tmp.remove(tmp.size()-1);
        }
    }
}
