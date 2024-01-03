class Solution {
    public int numberOfBeams(String[] bank) {
        // maintain a previous row device
        // count the current row
        int totalBeams = 0;
        int prevRow = 0;
        int currentRow = 0;
        
        // create the 2d matrix
        int[][] matrix = new int[bank.length][bank[0].length()];
        int x = 0;
        for(String s : bank) {
            for(int i=0; i<s.length(); i++) {
                matrix[x][i] = Integer.parseInt(s.charAt(i)+"");
            }
            x++;
        }
        
        // First row
        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[0][i] == 1) {
                prevRow ++;
            }
        }
        
        // From second row
        for(int i=1; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    currentRow++;
                }
            }
            if(currentRow > 0) {
                totalBeams += prevRow * currentRow;
                
                prevRow = currentRow;
                currentRow = 0;
            }
        }
        
        return totalBeams;
        
        
        
        
    }
}