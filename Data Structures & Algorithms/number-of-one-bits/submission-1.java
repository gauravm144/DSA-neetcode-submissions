class Solution {
    public int hammingWeight(int n) {
        int i=1;
        int ans=0;
        while(i!=0){
            if((i&n)!=0)
            ans++;
            i=i<<1;
        }
        return ans;
    }
}
