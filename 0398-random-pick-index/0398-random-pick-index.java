import java.util.Random;

class Solution {
    private int[] arr;
    private Random random;

    public Solution(int[] nums) {
        this.arr = nums;    
        this.random = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int result = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                count++;
                if(random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */