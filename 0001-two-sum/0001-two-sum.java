class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            if(hMap.containsKey(target - nums[i])) {
                return new int[] {i, hMap.get(target - nums[i])};
            }
            hMap.putIfAbsent(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}