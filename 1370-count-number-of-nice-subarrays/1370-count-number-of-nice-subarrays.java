class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private static int atMost(int[] nums, int k) {
        int res = 0;
        int start = 0;

        for(int end = 0; end<nums.length; end++) {
            if(nums[end] %2 == 1) {
                k--;
            }
            while(k < 0) {
                if(nums[start] % 2 == 1) {
                    k++;
                }
                start++;
            }
            res += end - start + 1;
        }
        return res;

    }

}