class Solution {
    public int findMin(int[] nums) {
        
        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int mid = left + (right - left)/2;


            if(nums[mid] > nums[mid+1] || nums[mid] > nums[nums.length-1]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}