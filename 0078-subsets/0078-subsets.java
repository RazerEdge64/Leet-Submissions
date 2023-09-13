class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums);
        backtrack(0, nums, list, result);        
        return result;   
    }

    // private void backtrack(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
    //     if(index >= nums.length) {
    //         result.add(new ArrayList<>(list));
    //         return;
    //     }
    //     list.add(nums[index]);
    //     backtrack(index + 1, nums, list, result);
    //     list.remove(list.size()-1);
    //     backtrack(index + 1, nums, list, result);
        
    // }

    private void backtrack(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {

        result.add(new ArrayList(list));

        for(int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            backtrack(i+1, nums, list, result);
            list.remove(list.size()-1);
        }
        
    }

}