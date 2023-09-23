class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];

        Arrays.fill(memo, -1);

        return dynamic(nums, 0, memo);
    }

    private int dynamic(int[] nums, int index, int[] memo) {
        if(index >= nums.length) {
            return 0;
        }

        if(memo[index] != -1) {
            return memo[index];
        }

        int current = nums[index] + dynamic(nums, index+2, memo);

        int skipCurrent = dynamic(nums, index+1, memo);

        memo[index] = Math.max(current, skipCurrent);

        return memo[index];
    }
}