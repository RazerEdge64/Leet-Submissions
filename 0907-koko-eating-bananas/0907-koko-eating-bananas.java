class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int k = 0;
        
        int max = piles[piles.length-1];
        int min = 1;

        while(min < max) {
            int mid = min + (max-min)/2;
            int totalHours = 0;
            for(int pile : piles) {
                totalHours += pile/mid;
                if(pile % mid > 0) { 
                    totalHours++; // rounding up for any remaining bananas
                }
            }

            if(totalHours <= h) {
                max = mid;  // even if totalHours == h, there might be a smaller mid
            } else {
                min = mid + 1;
            }
        }

        return min;  // min will point to the correct value after the loop

    }
}