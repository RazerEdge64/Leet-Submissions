class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Starting from the second row, update each cell
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Take the value directly above
                int minAbove = matrix[i - 1][j];

                // Check diagonally left above, if it's not on the first column
                if (j > 0) {
                    minAbove = Math.min(minAbove, matrix[i - 1][j - 1]);
                }

                // Check diagonally right above, if it's not on the last column
                if (j < n - 1) {
                    minAbove = Math.min(minAbove, matrix[i - 1][j + 1]);
                }

                // Update the current cell by adding the minimum above to its value
                matrix[i][j] += minAbove;
            }
        }

        // Find the minimum value in the last row
        int minPathSum = matrix[n - 1][0];
        for (int j = 1; j < n; j++) {
            minPathSum = Math.min(minPathSum, matrix[n - 1][j]);
        }

        return minPathSum;
    }
}
