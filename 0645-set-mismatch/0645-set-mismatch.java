class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int missing = 1;
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for (int i : nums) {
            hMap.put(i, hMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (hMap.containsKey(i)) {
                if (hMap.get(i) == 2) {
                    dup = i; // found the duplicate
                }
            } else {
                missing = i; // found the missing number
            }
        }

        return new int[]{dup, missing};
    }
}
