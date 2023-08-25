class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        combinationHelper(0, 0, target, candidates, ds, ans);

        return ans;
    }

    public static void combinationHelper(int index, int sum, int target, int[] candidates, List<Integer> ds, List<List<Integer>> ans) {
        if( sum == target ) {

            List<Integer> combination = new ArrayList<>(ds);
            Collections.sort(combination);
            ans.add(combination);
            return;
        }
        else if(sum > target || index == candidates.length) {
            return;
        }

        ds.add(candidates[index]);
        combinationHelper(index, sum+candidates[index], target, candidates, ds, ans);
        ds.remove(ds.size()-1);
        combinationHelper(index+1, sum, target, candidates, ds, ans);

    }
}