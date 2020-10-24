class Solution {
    public void setZeroes(int[][] matrix) {
        int len_x = matrix.length;
        int len_y = matrix[0].length;
        boolean[] record_x = new boolean[len_x];
        boolean[] record_y = new boolean[len_y];
        for (int i = 0; i < len_x; i++) {
            for (int j = 0; j < len_y; j++) {
                if (matrix[i][j] == 0) {
                    record_x[i] = true;
                    record_y[j] = true;
                }
            }
        }

        for (int i = 0; i < len_x; i++) {
            for (int j = 0; j < len_y; j++) {
                if (record_x[i] == true || record_y[j] == true ) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}