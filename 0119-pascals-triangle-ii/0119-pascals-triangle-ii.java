class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows  = rowIndex+1;
        int arr[][] = new int[rowIndex+1][rowIndex+1];

        for(int line=0 ; line < numRows ; line++) {
            for(int j=0 ; j <= line ; j++) {
                if(j == line || j==0) {
                    arr[line][j] =1;
                } else {
                    arr[line][j] = arr[line-1][j-1] + arr[line-1][j];
                }
            }
        }

        List<List<Integer>> triangle = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                row.add(arr[i][j]);
            }
            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }
    
}