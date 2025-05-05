class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] candidates, int remaining, int index) {
        if(remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(remaining < 0) return;

        for(int i=index; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(result, path, candidates, remaining - candidates[i], i);
            path.remove(path.size()-1);
        }
    }
}