class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // Important: initialize with a prefix sum of 0 having a count of 1.
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // Check how many prefix sums have sum-k. Those will contribute to the subarrays that sum to k.
            if(preSum.containsKey(sum - k)) {
                count += preSum.get(sum - k);
            }

            // Add the current prefix sum to the hashmap.
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

}