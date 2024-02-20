class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int length = nums.length;
        int expectedSum = length * (length+1)/2;
        for(int i=0 ; i<length ; i++) {
            sum+=nums[i];
        }
        return expectedSum-sum;
    }
}