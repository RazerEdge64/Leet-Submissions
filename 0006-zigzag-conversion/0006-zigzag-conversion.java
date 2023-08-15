class Solution {
    public String convert(String s, int numRows) {
        if(s.length()==1) return s;
        if(numRows <2) return s;
        int n = s.length();
        char[][] charArr = new char[numRows][(n/2)+1];

        int index = 0;
        int tempCol=0;
        int tempRow = 0;

        while(index<n && tempCol<=n/2 && tempRow<numRows) {
            // vertical column when i%numRows-1 == 0
            // System.out.println(index);
            // System.out.println(s.charAt(index));
            // System.out.println("tempRow- "+tempRow);
            // System.out.println("tempCol- "+tempCol);
            while(tempRow < numRows && index <n && tempCol<=n/2) {
                charArr[tempRow][tempCol] = s.charAt(index);
                tempRow++;
                index++;
            }

            // vertical done. Now the diagonal.
            tempCol++; // Next char or second char in the diagonal.
            tempRow=tempRow-2;
            while(tempRow > 0 && index < n && tempCol<n/2) {
                charArr[tempRow][tempCol] = s.charAt(index);
                tempRow--;
                tempCol++;
                index++;
            }

            // System.out.println(index);
            // System.out.println("After tempRow- "+tempRow);
            // System.out.println("After tempCol- "+tempCol);
            // System.out.println("-----");

        }

        // printArr(charArr);
        String res = new String("");

        for(int i=0; i<charArr.length; i++) {
            for(int j = 0; j<charArr[0].length; j++) {
                if(charArr[i][j]!=0) {
                    res+=charArr[i][j];
                }
            }
        }

        return res;


    }

    private static void printArr(char[][] charArr) {
        for(int i=0; i<charArr.length; i++) {
            for(int j = 0; j<charArr[0].length; j++) {
                System.out.print(charArr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}