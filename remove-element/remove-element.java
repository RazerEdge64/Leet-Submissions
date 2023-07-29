class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i]==val) {
                k--;
                nums[i]=-1;                
            }
            else {
                list.add(nums[i]);
            }
        }
        int i=0;
        for(Integer a : list) {
            nums[i] = a;
            i++;
        }
        
        return k;
    }
}