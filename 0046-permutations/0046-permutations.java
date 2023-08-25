class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        permuteHelper(nums, list, ans);

        return ans;
    }

    public void permuteHelper(int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == nums.length) {
            // if(!ans.contains(list))
                ans.add(new ArrayList<>(list));
            return;
        }
        else {
            for(int i = 0 ; i<nums.length ; i++) {
                if(list.contains(nums[i])) continue;
                list.add(nums[i]);
                permuteHelper(nums, list, ans);
                list.remove(list.size()-1);
            }
        }

    }
}