// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int rows=matrix.length;
//         int cols=matrix[0].length;
//         int i=0;
//         while(i<rows){
//             if(target>matrix[i][cols-1])
//             i++;
//             else
//             break;
//         }
//         if(i==rows)
//         return false;
        
//         int low=0,high=cols-1;
//         while(low<=high){
//             int mid=(low+high)/2;
//             if(target==matrix[i][mid])
//             return true;
//             else if(target>matrix[i][mid])
//             low=mid+1;
//             else
//             high=mid-1;
//         }
//         return false;
//     }
// }
// we can use better approach, think of this 2d into 1d
// mid jo hoga vo ek value hoga, lekin konsi
// r=mid/col
// c=mid%col
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int low=0,high=rows*cols-1;
        while(low<=high){
            int mid=(low+high)/2;
            int r=mid/cols;
            int c=mid%cols;
            if(target==matrix[r][c])
            return true;
            else if(target>matrix[r][c])
            low=mid+1;
            else
            high=mid-1;
        }
        return false;
    }
}