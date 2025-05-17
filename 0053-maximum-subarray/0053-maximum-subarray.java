// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max = nums[0];
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = i; j < nums.length; j++) {
//                 int sum = 0;
//                 for(int k = i; k <= j; k++) {
//                     sum += nums[k];
//                 }
//                 if(sum > max) {
//                     max = sum;
//                 }
//             }
//         }
//         return max;
//     }
// }

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxGlobal = nums[0];
//         int maxCurrent = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
//             maxGlobal = Math.max(maxGlobal, maxCurrent);
//         }

//         return maxGlobal;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        int maxGlobal = nums[0];
        int maxCurrent = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            
            maxCurrent = Math.max(nums[i], maxCurrent+nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        
        return maxGlobal;
    }
}

