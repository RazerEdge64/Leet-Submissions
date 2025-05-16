class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // rob1, rob2, n, n+1 ...
        int rob1 = 0;
        int rob2 = 0;

        for(int i=0; i<n; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}