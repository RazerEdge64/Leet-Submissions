class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int start = 0;
        for(int i=0; i<matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(matrix[i][mid] == target) {
                    return true;
                }
                if(target > matrix[i][mid]) {
                    start = mid+1;
                }
                else if(target < matrix[i][mid]) {
                    end = mid-1;
                }
            }
        }

        return false;
    }
}