class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[][] memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return path(0, 0, grid, memo);
    }

    private int path(int i, int j, int[][] grid, int[][] memo) {
        if(i==grid.length-1 && j==grid[0].length-1) {
            return 1;
        }
        if(i>= grid.length || j>= grid[0].length) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        memo[i][j] = path(i+1, j, grid, memo) + path(i, j+1, grid, memo);

        return memo[i][j];
    }
}