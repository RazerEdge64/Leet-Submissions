class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i< rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols-1);
        }

        for(int i=0; i<cols; i++) {
            dfs(board, 0, i);
            dfs(board, rows-1, i);
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if(i<0 || j<0 || i>=rows || j>=cols || board[i][j] !='O' ) return;

        board[i][j] = '#';

        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    } 
}