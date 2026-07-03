class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;

        int[] right=new int[n];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }

        int left=1;
        for(int i=1;i<n;i++){
            int tmp=nums[i-1];
            nums[i-1]=left*right[i-1];
            left=left*tmp;
        }
        nums[n-1]=left*right[n-1];
        return nums;
    }
}  

//1,1,2,8

// 1,2,4,6
//48,24,6,1

