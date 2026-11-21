class Solution {
    public int findChange(int[] coins, int amount, int[] dp)
    {
        if(amount == 0) return 0;
        int minNoOfCoins = Integer.MAX_VALUE;
        if(dp[amount] != 0) return dp[amount];
        for(int i=0;i<coins.length;i++)
        {
            if(coins[i] > amount) break;
            int noOfCoins = findChange(coins,amount-coins[i],dp);
            if(noOfCoins != Integer.MAX_VALUE)
            minNoOfCoins = Math.min(minNoOfCoins, 1 + noOfCoins);
        }
        dp[amount] = minNoOfCoins;
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int dp[] = new int[amount+1];
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++)
        {
            int minNoOfCoins = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j] > i) break;
                int noOfCoins = dp[i-coins[j]];
                if(noOfCoins != Integer.MAX_VALUE)
                minNoOfCoins = Math.min(minNoOfCoins, 1 + noOfCoins);
            }
            dp[i] = minNoOfCoins;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
