class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=1;i<=n;i++){
            ans[i]=hammingWeight(i);
        }
        return ans;
    }
    int hammingWeight(int n) {
        int ans=0;
        while(n!=0){
            if((1&n)!=0)
            ans++;
            n=n>>1;
        }
        return ans;
    }
}
