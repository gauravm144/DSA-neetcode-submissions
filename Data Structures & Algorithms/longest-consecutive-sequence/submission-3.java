class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        mp.put(nums[i],true);

        for(int i=0;i<nums.length;i++)
        if(mp.containsKey(nums[i]-1))
        mp.put(nums[i],false);

        int ans=0;
        for(int i=0;i<nums.length;i++){
            int tmp=1;
            if(mp.get(nums[i])==true){
                int val=nums[i]+1;
                while(mp.containsKey(val)){
                    val++;
                    tmp++;
                }
            }
            ans=Math.max(ans,tmp);
        }

        
        return ans;
    }
}
