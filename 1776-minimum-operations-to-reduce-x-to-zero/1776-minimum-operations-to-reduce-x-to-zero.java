class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum=0;
        int currentSum = 0;
        int left = 0;
        int maxLength = -1;
        for(int num : nums) {
            totalSum+=num;
        }

        for(int right = 0; right<nums.length; right++) {
            currentSum += nums[right];

            while(currentSum > totalSum-x && left<=right) {
                currentSum-=nums[left];
                left++;
            }

            if(currentSum == totalSum -x) {
                maxLength = Math.max(maxLength, right-left+1);
            }
        }


        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}