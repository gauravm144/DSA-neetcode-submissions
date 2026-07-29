class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        set.add(nums[i]);

        int ans=0;
        for(int i=0;i<nums.length;i++){
            int tmp=1;
            if(!set.contains(nums[i]-1)){
                int val=nums[i]+1;
                while(set.contains(val)){
                    val++;
                    tmp++;
                }
            }
            ans=Math.max(ans,tmp);
        }

        
        return ans;
    }
}
