class Solution {
    public int maxProfit(int[] current) {
        // intitution
        // ek maximum amount set krlo aur cureent pr dekho current-min is giving max answer?
        int potential=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<current.length;i++){
            potential=Math.min(potential,current[i]);
            ans=Math.max(ans,current[i]-potential);
        }
        return ans;
    }
}
