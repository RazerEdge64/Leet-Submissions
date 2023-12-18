class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int lastIndex = nums.length-1;
        
        return nums[lastIndex] * nums[lastIndex-1] - (nums[0]*nums[1]);
    }
}