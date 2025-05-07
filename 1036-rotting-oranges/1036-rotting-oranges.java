class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) return 0;

        int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        int minutes = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for(int i=0; i<size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                
                for(int[] direction: directions) {
                    int r = row + direction[0];
                    int c = col + direction[1];

                    if( r<0 || c<0 || r>=m || c>=n || grid[r][c]!=1 ) continue;
                    grid[r][c] = 2;
                    freshOranges--;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;

    }
}