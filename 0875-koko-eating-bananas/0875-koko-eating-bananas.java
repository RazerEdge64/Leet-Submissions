class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0; i<piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }

        int start = 1;
        int end = max;

        while(start < end) {
            int k = start + (end - start) / 2;
            // Now here, we need to find the target.
            // its almost like reverse binary search.
            // what is the relationship between k & h
            int totalHours = 0;
            for(int pile: piles) {
                totalHours += Math.ceil( (double) pile / k);
            }

            if(totalHours <= h) {
                end = k;
            }
            else {
                start = k+1;
            }
        }
        return start;
    }
}