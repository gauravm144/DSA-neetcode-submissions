class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;

        List<Integer> ans = new ArrayList<>();

        while (l <= r && u <= d) {

            // left -> right
            for (int i = l; i <= r; i++) {
                ans.add(matrix[u][i]);
            }
            u++;

            // top -> bottom
            for (int i = u; i <= d; i++) {
                ans.add(matrix[i][r]);
            }
            r--;

            // right -> left
            if (u <= d) {
                for (int i = r; i >= l; i--) {
                    ans.add(matrix[d][i]);
                }
                d--;
            }

            // bottom -> top
            if (l <= r) {
                for (int i = d; i >= u; i--) {
                    ans.add(matrix[i][l]);
                }
                l++;
            }
        }

        return ans;
    }
}