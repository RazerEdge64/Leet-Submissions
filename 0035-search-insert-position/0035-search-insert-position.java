class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }

    private int binarySearch(int low, int high, int[] nums, int target) {
        if(low > high) {
            return low;
        } 

        int mid = low + (high - low) / 2;

        if(target == nums[mid]) {
            return mid;
        }

        if(target > nums[mid]) {
            return binarySearch(mid + 1, high, nums, target);
        } else {
            return binarySearch(low, mid - 1, nums, target);
        }
    }
}
