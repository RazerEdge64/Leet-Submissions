class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, int index) {
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(result, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}