class Solution {
    public int search(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            }

            if(target>nums[mid]) {
                start = mid+1;
            }
            else if(target<nums[mid]) {
                end = mid-1;
            }
        }

        return -1;
    }
}