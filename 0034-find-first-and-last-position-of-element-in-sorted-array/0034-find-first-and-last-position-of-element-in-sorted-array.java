class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = fromStart(target, nums);
        res[1] = fromEnd(target, nums);

        return res;
    }

    public static int fromStart(int target, int[] nums) {
        // Can use binary search here
        for(int i=0; i<nums.length ; i++) {
            if(nums[i]==target) return i;
        }
        return -1;
    }

    public static int fromEnd(int target, int[] nums) {
        // Can use binary search here
        for(int i=nums.length-1 ; i>=0 ; i--) {
            if(nums[i]==target) return i;
        }

        return -1;
    }
}