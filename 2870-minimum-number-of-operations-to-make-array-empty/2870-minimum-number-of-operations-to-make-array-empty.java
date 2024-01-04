class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }

        for (int count : hMap.values()) {
            if (count == 1) {
                return -1;
            }

            ans += count / 3;
            if (count % 3 != 0) {
                ans += 1;
            }
        }

        return ans;
    }
}
