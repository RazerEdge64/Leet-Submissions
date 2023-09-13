class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtrack(i, j, board, word, 0))
                    return true;
            }
        }
        return false;

    }

    private boolean backtrack(int i, int j, char[][] board, String word, int idx) {
        if(idx == word.length())
            return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;

        char temp = board[i][j];
        board[i][j] = '#'; // Mark cell as visited.

        boolean found = backtrack(i+1, j, board, word, idx+1) ||
                        backtrack(i-1, j, board, word, idx+1) ||
                        backtrack(i, j+1, board, word, idx+1) ||
                        backtrack(i, j-1, board, word, idx+1);

        board[i][j] = temp; // revert the change (backtrack).

        return found;
    }
}