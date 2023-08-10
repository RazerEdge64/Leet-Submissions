class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        if(board==null) return;
        
        for(int i=0; i<board.length; i++) {
            
            for(int j=0; j<board[0].length; j++) {
                int count = 0;
                
                //top
                if( (j-1) >= 0 && board[i][j-1]==1) {
                    System.out.println("top "+i+" "+j);
                    count++;
                }
                //bottom
                if( (j+1)<board[0].length && board[i][j+1]==1) {
                    System.out.println("bottom "+i+" "+j);
                    count++;
                }
                //left
                if( (i-1) >= 0 && board[i-1][j]==1) {
                    System.out.println("left "+i+" "+j);
                    count++;
                }

                //right
                if( (i+1)<board.length && board[i+1][j]==1) {
                    System.out.println("right "+i+" "+j);
                    count++;
                }
                
                // topLeft
                if((i-1)>=0 && (j-1)>=0 && board[i-1][j-1] ==1) {
                    System.out.println("Tleft "+i+" "+j);
                    count++;
                }
                //topRight
                if((i-1)>=0 && (j+1)<board[0].length && board[i-1][j+1] ==1) {
                    System.out.println("Tright "+i+" "+j);
                    count++;
                }
                //bottomLeft
                if((i+1)<board.length && (j-1)>=0 && board[i+1][j-1] ==1) {
                    System.out.println("Bleft "+i+" "+j);
                    count++;
                }
                //bottomRight
                if((i+1)<board.length && (j+1)<board[0].length && board[i+1][j+1] ==1) {
                    System.out.println("Bright "+i+" "+j);
                    count++;
                }
                
                
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }

            }
            System.out.println();
            
            
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
}