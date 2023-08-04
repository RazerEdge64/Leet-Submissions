class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;        
        int left = 1, right=1;
        int[] res = new int[n];
        res[0]= 1;
        for(int i=1 ; i<n; i++) {
            left = left*nums[i-1];
            res[i] = left;
        }
        
        for(int i=n-2; i>=0; i--) {
            right = right * nums[i+1];
            res[i] *= right;
        }
        
        return res;
        
        
    }
}