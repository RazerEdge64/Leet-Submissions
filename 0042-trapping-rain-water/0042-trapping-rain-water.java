class Solution {
    public int trap(int[] height) {
        int rainwater = 0;
        int length = height.length;
        for(int i = 0 ; i<length ; i++) {
            // Rainwater stored is minimum of max elevation to the left and right.
            int j = i;
            int leftMax = 0;
            int rightMax = 0;

            while(j>=0) {
                
                leftMax = Math.max(leftMax , height[j]);
                j--;
            }

            j = i;

            while(j<length) {
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            rainwater += Math.min(leftMax, rightMax) - height[i]; 
        }

        return rainwater;
    }
}