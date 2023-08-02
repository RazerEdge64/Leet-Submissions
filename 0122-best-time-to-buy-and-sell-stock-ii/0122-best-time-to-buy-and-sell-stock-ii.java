class Solution {
    public int maxProfit(int[] prices) {
        //Write your code here

        int dp[][] = new int[prices.length+1][2];
        for(int row[]: dp)
        Arrays.fill(row,-1);

        //base condition
        dp[prices.length][0] = dp[prices.length][1] = 0;

        int profit=0;

        for(int ind= prices.length-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                if(buy==0){// We can buy the stock
                    profit = Math.max(0+dp[ind+1][0], -prices[ind] + dp[ind+1][1]);
                }

                if(buy==1){// We can sell the stock
                    profit = Math.max(0+dp[ind+1][1], prices[ind] + dp[ind+1][0]);
                }

                dp[ind][buy]  = profit;
            }
        }
        return dp[0][0];

    }
}