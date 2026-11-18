class Solution {
    public  int catalanMemo(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = 0; // Cn
        for(int i=0;i<=n-1;i++) {
            ans += catalanMemo(i, dp)*catalanMemo(n-i-1, dp);
        }

        return dp[n] = ans;
    }
    public int numTrees(int n) {

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        return catalanMemo(n, dp);
   }
}