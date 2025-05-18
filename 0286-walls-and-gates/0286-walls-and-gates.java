class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if(r<0 || c<0 || r>=m || c>=n || rooms[r][c] != Integer.MAX_VALUE) continue;

                rooms[r][c] = rooms[row][col] + 1;
                queue.offer(new int[]{r, c});
            }
        }

        return;
    }
}