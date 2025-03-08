class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minChanges = Integer.MAX_VALUE;
        int whiteCount = 0;

        for(int i=0; i<k; i++) {
            if(blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        minChanges = whiteCount;

        for(int i = k; i<blocks.length(); i++) {
            if(blocks.charAt(i-k) == 'W') {
                whiteCount--;
            }

            if(blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            minChanges = Math.min(minChanges, whiteCount);
        }

        return minChanges;
    }
}