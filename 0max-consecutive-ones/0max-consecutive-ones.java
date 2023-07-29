class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        if(nums.length == 1) {
            if(nums[0]==1) return 1;
            else return 0;
        }
        if(nums.length == 2) {
            if(nums[0]==1 && nums[1]==1) return 2;
            else if(nums[0]==0 && nums[1]==0) return 0;
            else return 1;
        }
        for(int i = 1 ; i<nums.length ; i++) {
            int localMax = (nums[0]==1)? 1 : 0;
            System.out.println("here");
            if(nums[i-1]==1 && nums[i]==1) {
                System.out.println("here 2");
                int k = i+1;
                localMax = 2;
                while(k<nums.length && nums[k]==1) {
                    localMax +=1;
                    k++;
                }
                
            }
            max = Math.max(max, localMax);

        }

        return max;
    }
}