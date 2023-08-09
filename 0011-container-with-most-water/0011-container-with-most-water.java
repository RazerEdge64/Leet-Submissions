class Solution {
    public int maxArea(int[] height) {
        int maxSum = 0;
        // for(int i = 0 ; i<height.length-1 ; i++) {
        //     for(int j = i+1 ; j<height.length ; j++) {
        //         maxSum = Math.max(maxSum,(Math.abs(i-j)*Math.min(height[i], height[j])));
        //     }
        // }

        int i = 0;
        int j = height.length-1;
        while(i<j) {
            maxSum = Math.max(Math.abs(i-j) * Math.min(height[i], height[j]), maxSum);


            if(height[i] > height[j]) {
                j--;
            }
            else{
                i++;
            }
        }

        
        return maxSum;
    }
    
}