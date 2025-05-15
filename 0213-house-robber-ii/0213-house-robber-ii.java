class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(helper(0, n-2, nums) , helper(1, n-1, nums));
    }

    private int helper(int start, int end, int[] nums) {
        int rob1 = 0, rob2 = 0;

        for(int i=start; i<=end; i++) {
            int curr = Math.max(rob1 + nums[i] , rob2);
            rob1 = rob2;
            rob2 = curr;
        }

        return rob2;
    }
}