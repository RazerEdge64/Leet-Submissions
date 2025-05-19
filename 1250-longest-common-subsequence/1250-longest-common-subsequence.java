class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, 0, text1, text2, memo);
    }

    private int dp(int i, int j, String text1, String text2, int[][] memo) {
        if(i==text1.length() || j == text2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        if(text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(i+1, j+1, text1, text2, memo);
        } else {
            int skipText1 = dp(i+1, j, text1, text2, memo);
            int skipText2 = dp(i, j+1, text1, text2, memo);
            memo[i][j] = Math.max(skipText1, skipText2);
        }

        return memo[i][j];
    }
}