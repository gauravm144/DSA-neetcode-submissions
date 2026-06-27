class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> mp=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        mp.add(nums[i]);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(!mp.contains(n-1)){
                int start=1;
                while(mp.contains(n+1)){
                    start++;
                    n++;
                }
                ans=Integer.max(ans,start);
            }
        }
        return ans;
    }
}

// intution ye h ki pehle set bnalo fer dekho ki cur ke prev koi h agar hn mtlb ye starting ni h, agar ni to
// cur se inc order mai kitne exists krre hai vha tk jao