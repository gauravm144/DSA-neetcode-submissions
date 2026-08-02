class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l=0,r=matrix[0].length-1;
        int u=0,d=matrix.length-1;
        List<Integer> ans=new ArrayList<>();
        while(l<=r&&u<=d){
            for(int i=l;i<=r&&u<=d;i++){
                ans.add(matrix[u][i]);
            }
            u++;
            for(int i=u;i<=d&&l<=r;i++){
                ans.add(matrix[i][r]);
            }
            r--;
            for(int i=r;i>=l&&d>=u;i--){
                ans.add(matrix[d][i]);
            }
            d--;
            for(int i=d;i>=u&&r>=l;i--){
                ans.add(matrix[i][l]);
            }
            l++;
        }
        return ans;
    }
}
