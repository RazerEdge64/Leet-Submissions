class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        combinationHelper(0, target, candidates, list, ans);

        return ans;
    }

    public static void combinationHelper (int index, int target, int [] candidates, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index ; i< candidates.length ; i++) {
            if(i>index && candidates[i]==candidates[i-1]) {
                continue;
            }
            if(candidates[i] > target) {
                break;
            }

            list.add(candidates[i]);
            combinationHelper(i+1, target-candidates[i], candidates, list, ans);
            list.remove(list.size()-1);
        }

    }
}