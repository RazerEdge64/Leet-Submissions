class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) {
            return false;
        }
        if(nums.length == 2) {
            return nums[0] == nums[1];
        }

        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]==nums[i+1]) {
                return true;
            }
        }

        return false; 
    }
}