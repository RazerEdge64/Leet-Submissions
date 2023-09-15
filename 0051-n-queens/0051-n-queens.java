class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        backtrack(0, board, res);

        return res;
    }

    private void backtrack(int col, char[][]board, List<List<String>> res) {
        if(col == board.length) {
            res.add(construct(board));
            return;
        }

        for(int row=0; row<board.length; row++) {
            if(isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(col+1, board, res);
                board[row][col] = '.';
            }
        }

    }

    private boolean isSafe(int row, int col, char[][] board) {
        // upper diagonal.
        int dummyRow = row;
        int dummyCol = col;
        while(col>=0 && row>=0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dummyRow;
        col = dummyCol;

        // same row.
        while(col>=0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = dummyRow;
        col = dummyCol;
        // lower diagonal

        while(row<board.length && col>=0) {
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for(int i=0; i<board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}