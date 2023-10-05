class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            if(map.containsKey(nums[i])){
                int currentValue = map.get(nums[i]);
                currentValue++;
                map.replace(nums[i], currentValue);             
            }
            else{
                map.put(nums[i],1);
            }
        }

        for(int i=0 ; i<n ; i++) {
            int count = map.get(nums[i]);
            if(count>n/3) {
                if(!list.contains(nums[i])){
                    list.add(nums[i]);
                }
                
            }
        }

        return list;

    }
}