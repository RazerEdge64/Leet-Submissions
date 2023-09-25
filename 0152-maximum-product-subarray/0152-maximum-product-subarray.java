class Solution {
    public int maxProduct(int[] nums) {
        int maxRight = 0;
        int maxLeft = 0;
        boolean zeroPresent = false;
        int prod = 1;

        if(nums.length==1) {
            return nums[0];
        }

        for(int a :  nums) {
            if(a==0) {
                prod = 1;
                zeroPresent = true;
                continue;
            }
            prod *= a;
            maxLeft = Math.max(maxLeft, prod);
        }

        prod = 1;

        for(int i=nums.length-1 ; i>=0 ; i--) {
            if(nums[i]==0) {
                prod = 1;
                zeroPresent = true;
                continue;
            }
            prod *= nums[i];

            maxRight = Math.max(maxRight, prod);
        }

        if(zeroPresent) {
            return Math.max(Math.max(maxLeft,0) , Math.max(0, maxRight));
        }

        return Math.max(maxLeft, maxRight);

    }
}