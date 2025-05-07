class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<m; i++) {
            dfs(heights, pacific, i, 0); // left
            dfs(heights, atlantic, i, n-1); // right
        }

        for(int j=0; j<n; j++) {
            dfs(heights, pacific, 0, j); // top
            dfs(heights, atlantic, m-1, j); // bottom
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        int m = heights.length, n = heights[0].length;
        visited[i][j] = true;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] dir : directions) {
            int r = i+dir[0];
            int c = j+dir[1];

            if(r<0 || c<0 || r>=m || c>=n || visited[r][c]) continue;
            if(heights[r][c] < heights[i][j]) continue;
            dfs(heights, visited, r, c);
        }
    }
}