class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        
        int robFirst = dynamic(0, nums.length - 2, nums, memo1);
        int skipFirst = dynamic(1, nums.length - 1, nums, memo2);
        
        return Math.max(robFirst, skipFirst);
    }

    private int dynamic(int start, int end, int[] nums, int[] memo) {
        if (start > end) {
            return 0;
        }
        
        if (memo[start] != -1) {
            return memo[start];
        }
        
        int robCurrent = nums[start] + dynamic(start + 2, end, nums, memo);
        int skipCurrent = dynamic(start + 1, end, nums, memo);

        memo[start] = Math.max(robCurrent, skipCurrent);
        return memo[start];
    }
}
