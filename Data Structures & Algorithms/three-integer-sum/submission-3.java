class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2){
            if(i>0&&nums[i]==nums[i-1])
            {
                i++;
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(j-1!=i&&nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    ans.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(sum<0)
                j++;
                else
                k--;
            }
            i++;
        }
    return ans;
    }
}
