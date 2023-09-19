class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] reachedPacific = new boolean[m][n];
        boolean[][] reachedAtlantic = new boolean[m][n];

        // Start DFS from the boundaries
        for(int i=0; i<m; i++) {
            dfs(i, 0, heights, reachedPacific, Integer.MIN_VALUE);
            dfs(i, n-1, heights, reachedAtlantic, Integer.MIN_VALUE);
        }
        
        for(int j=0; j<n; j++) {
            dfs(0, j, heights, reachedPacific, Integer.MIN_VALUE);
            dfs(m-1, j, heights, reachedAtlantic, Integer.MIN_VALUE);
        }

        // Gather results
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(reachedPacific[i][j] && reachedAtlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] reached, int prevHeight) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if (reached[i][j] || heights[i][j] < prevHeight) return; // Check flow condition

        reached[i][j] = true;
        
        dfs(i+1, j, heights, reached, heights[i][j]);
        dfs(i-1, j, heights, reached, heights[i][j]);
        dfs(i, j+1, heights, reached, heights[i][j]);
        dfs(i, j-1, heights, reached, heights[i][j]);
    }
}
