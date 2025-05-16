class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, int index) {
        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        backtrack(result, path, nums, index+1);
        path.remove(path.size()-1);
        backtrack(result, path, nums, index+1);
    }
}