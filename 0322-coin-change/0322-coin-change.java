class Solution {
    public static int coinsChange(int coin[] , int sum) {
        int n = coin.length;
        int dp[][] = new int[n+1][sum+1];
        
        // initialize - sum is 0
        // i -> coins, j -> sum/change
        for(int i=0;i<n+1;i++) {
            dp[i][0] = 0;
        }

        for(int j=1;j<sum+1;j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        // O(n*sum)
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(coin[i-1] <= j) { // valid condition
                    dp[i][j] = Math.min(
                        1 + dp[i][j - coin[i-1]],
                        dp[i-1][j]
                    );// include + exclude
                } else { // invalid condition
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum] == Integer.MAX_VALUE - 1
                ? -1 : dp[n][sum];
    }
    public int coinChange(int[] coins, int amount) {
        return coinsChange(coins, amount);
    }
}