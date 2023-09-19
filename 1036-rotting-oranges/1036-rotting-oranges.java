class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for(int i=0; i<rows ; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j]==2) {
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] ==1) {
                    freshCount ++;
                }
            }
        }

        if(freshCount == 0) {
            return 0;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int mins = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] current = queue.poll();

                for(int [] dir : directions) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if(x>=0 && x< rows && y>=0 && y<cols && grid[x][y]==1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                        freshCount--;
                    }


                }

            }


            if(!queue.isEmpty()) {
                mins++;
            }
        }

        return freshCount==0? mins : -1;
    }
}