class Solution {
    public void setZeroes(int[][] matrix) {
        List rows = new ArrayList<Integer>();
        List cols = new ArrayList<Integer>();

        for(int i=0 ; i< matrix.length ; i++) {
            for( int j = 0; j< matrix[i].length ; j++) {
                if(matrix[i][j] == 0) {
                    if(!rows.contains(i)) {
                        rows.add(i);
                    }
                    if(!cols.contains(j)) {
                        cols.add(j);
                    }
                }
            }
        }

        for(int i=0 ; i< matrix.length ; i++) {
            for( int j = 0; j< matrix[i].length ; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j]=0;
                }
            }
        }

    }
}