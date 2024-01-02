class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // make a frequency hashmap
        // iterate based on the frequency
        // update frequency
        List<List<Integer>> ans = new ArrayList<>();
        
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            hMap.put(nums[i], hMap.getOrDefault(nums[i], 0) + 1);
        }
        
        while(!hMap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();    
            Set<Integer> keys = new HashSet<>(hMap.keySet());
            
            for(Integer key : keys){
                if(hMap.get(key)>0) {
                    temp.add(key);
                    hMap.put(key, hMap.get(key)-1);
                    if(hMap.get(key) == 0) {
                        hMap.remove(key);
                    }
                }
                // System.out.println("Key: " + key + ", Value: " + value);
            }
            
            ans.add(temp);
        }
        

        
        // List<Integer> temp = new ArrayList<>();
            
        return ans;
    }
}