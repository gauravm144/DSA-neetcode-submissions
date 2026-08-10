class Solution {
    public void setZeroes(int[][] matrix) {

        boolean does_firstcol_has_zero = false;
        boolean does_firstrow_has_zero = false;

        // 1. Mark rows and columns
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {

                    if (i == 0) {
                        does_firstrow_has_zero = true;
                    }

                    if (j == 0) {
                        does_firstcol_has_zero = true;
                    }

                    if (i != 0 && j != 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        // 2. Use markers to zero inner matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 3. Zero first row
        if (does_firstrow_has_zero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // 4. Zero first column
        if (does_firstcol_has_zero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}