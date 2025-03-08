class Solution {
    public int trap(int[] height) {
        int water = 0;
        int start = 0;
        int end = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while(start < end) {
            if(height[start] < height[end]) {
                if(height[start] >= leftMax) {
                    leftMax = height[start];
                }
                else {
                    water += leftMax - height[start];
                }
                start++;
            }
            else {
                if(height[end] >= rightMax) {
                    rightMax = height[end];
                }
                else {
                    water += rightMax - height[end];
                }
                end--;
            }
        }

        return water;
    }
}