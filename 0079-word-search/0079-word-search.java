class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if((word.charAt(0) == board[i][j]) && dfs(board, used, word, i, j, 0) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] used, String word, int i, int j, int index) {
        if(index == word.length()) {
            return true;
        }

        if((i<0 || j<0 || i>= board.length || j >= board[0].length || word.charAt(index) != board[i][j])) return false;
        
        if(used[i][j]) return false;

        used[i][j] = true;
        boolean found =  dfs(board, used, word, i+1, j, index+1) || 
                dfs(board, used, word, i-1, j, index+1) || 
                dfs(board, used, word, i, j+1, index+1) || 
                dfs(board, used, word, i, j-1, index+1);

        used[i][j] = false;

        return found;
    }

}