class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int nums[], int index) {
        result.add(new ArrayList<>(path));

        for(int i = index; i<nums.length; i++) {
            path.add(nums[i]);
            backtrack(result, path, nums, i+1);
            path.remove(path.size()-1);
        }
        
    }
}