class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]!=0){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
            }
            j++;
        }
    }
}