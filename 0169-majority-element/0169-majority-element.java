class Solution {
    public int majorityElement(int[] nums) {

        // int mNumber = nums.length/2;
        // for(int i=0; i<nums.length ; i++) {
        //     int temp = nums[i];
        //     int occurence = 0;
        //     for(int j=0 ; j<nums.length ; j++) {
        //         if(nums[j]==temp) {
        //             occurence++;
        //         }
        //     }
        //     if(occurence>mNumber) {
        //         return temp;
        //     }
        // }
        // return 0;
        Arrays.sort(nums);
        return nums[nums.length/2];

    }
}