class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if(r<0 || c<0 || r>=m || c>=n || visited[r][c]) continue;
                mat[r][c] = mat[row][col] + 1;
                visited[r][c] = true;
                queue.offer(new int[] {r, c});
            }
        }

        return mat;
    }
}