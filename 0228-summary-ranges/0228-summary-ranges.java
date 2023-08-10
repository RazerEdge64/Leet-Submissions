class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        
        List<String> list = new ArrayList<>();
        if(nums==null || nums.length==0) return list;
        
        int i=0;
        while(i<nums.length) {
            int start = nums[i];
            int end = nums[i];
            int j = i + 1;

            // Find the end of the consecutive range
            while (j < nums.length && nums[j] - nums[j - 1] == 1) {
                end = nums[j];
                j++;
            }

            // Add the range to the list
            if (start == end) {
                list.add(Integer.toString(start));
            } else {
                list.add(start + "->" + end);
            }

            // Move the outer loop index to the next range
            i = j;        
        }
        
        return list;
    }
}
