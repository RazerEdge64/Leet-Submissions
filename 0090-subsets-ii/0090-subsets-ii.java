class Solution {
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     List<Integer> list = new ArrayList<>();
    //     List<List<Integer>> ans = new ArrayList<>();
    //     subsetHelper(0, nums, list, ans);
    //     return ans;

    // }

    // public static void subsetHelper(int index, int[] nums, List<Integer> list, List<List<Integer>> ans) {
    //     if(index == nums.length) {
    //         List<Integer> temp = new ArrayList<>(list);
    //         Collections.sort(temp);
    //         if(!ans.contains(temp))
    //             ans.add(temp);
    //         return;
    //     }

    //     list.add(nums[index]);
    //     subsetHelper(index+1, nums, list, ans);
    //     list.remove(list.size()-1);
    //     subsetHelper(index+1, nums, list, ans);
    // }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetHelper(0, nums, list, ans);
        return ans;

    }    

    public static void subsetHelper(int index, int[] nums, List<Integer> list,  List<List<Integer>> ans) {
        ans.add(new ArrayList(list));

        for(int idx = index; idx<nums.length; idx++) {
            if(idx > index && nums[idx] == nums[idx-1]) continue;
            list.add(nums[idx]);
            subsetHelper(idx+1, nums, list, ans);
            list.remove(list.size()-1);
        }
    }
}