class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String squareStr = Integer.toString(square);

            if (canPartition(squareStr, 0, i, 0)) {
                sum += square;
            }
        }
        return sum;
    }

    // Recursive function to check if we can partition the square's digits to sum to num
    private boolean canPartition(String s, int index, int target, int currentSum) {
        if (index == s.length()) {
            return currentSum == target;
        }

        int num = 0;
        for (int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');

            if (num + currentSum > target) {
                return false; // Early exit if sum exceeds target
            }

            if (canPartition(s, i + 1, target, currentSum + num)) {
                return true;
            }
        }

        return false;
    }
}