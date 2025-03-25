class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return canCut(rectangles, true) || canCut(rectangles, false);
    }

    private boolean canCut(int[][] rectangles, boolean vertical) {
        // Sort rectangles based on either startX or startY
        Arrays.sort(rectangles, (a, b) -> vertical ? a[0] - b[0] : a[1] - b[1]);
        int len = rectangles.length;

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // Check group 1: 0 to i-1
                int max1 = vertical ? getMax(rectangles, 0, i, 2) : getMax(rectangles, 0, i, 3);
                int min2 = vertical ? getMin(rectangles, i, j, 0) : getMin(rectangles, i, j, 1);
                if (max1 > min2) continue;

                int max2 = vertical ? getMax(rectangles, i, j, 2) : getMax(rectangles, i, j, 3);
                int min3 = vertical ? getMin(rectangles, j, len, 0) : getMin(rectangles, j, len, 1);
                if (max2 > min3) continue;

                // Found valid cut
                return true;
            }
        }

        return false;
    }

    private int getMin(int[][] rects, int start, int end, int index) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, rects[i][index]);
        }
        return min;
    }

    private int getMax(int[][] rects, int start, int end, int index) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(max, rects[i][index]);
        }
        return max;
    }
}