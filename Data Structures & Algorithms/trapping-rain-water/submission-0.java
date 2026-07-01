class Solution {
    public int trap(int[] height) {
        int n=height.length;

        int[] left=new int[n];
        left[0]=0;
        int maxheightleft=height[0];
        for(int i=1;i<n;i++){
            left[i]=maxheightleft;
            if(height[i]>maxheightleft){
                maxheightleft=height[i];
            }
        }
        for(int i=0;i<n;i++)
        System.out.print(left[i]+" ");

        System.out.println();

        int[] right=new int[n];
        right[n-1]=0;
        int maxheightright=height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=maxheightright;
            if(height[i]>maxheightright){
                maxheightright=height[i];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
        System.out.print(right[i]+" ");
        if(Math.min(left[i],right[i])>=height[i])
        ans+=Math.min(left[i],right[i])-height[i];
        }

        return ans;
    }
}
