class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Map<Integer, Integer> memo = new HashMap<>();
        int res = backtrack(memo, coins, amount);
        return (res == Integer.MAX_VALUE) ? -1:res;
    }

    private int backtrack(Map<Integer, Integer> memo, int[] coins, int amount) {
        if(amount < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(memo.containsKey(amount)) return memo.get(amount);
        
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int subResult = backtrack(memo, coins, amount - coin);
            if(subResult != Integer.MAX_VALUE) {
                res = Math.min(res, 1+ subResult);
            }
            
        }
        memo.put(amount, res);
        return res;
    }
}