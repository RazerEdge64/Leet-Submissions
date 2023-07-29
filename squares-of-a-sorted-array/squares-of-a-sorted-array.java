class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums==null) {
            return new int[0];
        }
        for(int i=0 ; i<nums.length ; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}