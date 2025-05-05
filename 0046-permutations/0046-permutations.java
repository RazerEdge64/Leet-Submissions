class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] used) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i<nums.length; i++) {
            if(used[i]) continue;

            path.add(nums[i]);
            used[i] = true;
            backtrack(result, path, nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}