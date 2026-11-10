class Solution {
    int[][] dp;

    public int helper(List<Integer> cuts, int i, int j) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int idx = i; idx <= j; idx++) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1);
            int left = helper(cuts, i, idx - 1);
            int right = helper(cuts, idx + 1, j);

            ans = Math.min(ans, cost + left + right);
        }

        return dp[i][j] = ans;
    }

    public int minCost(int n, int[] cutsArray) {
        List<Integer> cuts = new ArrayList<>();

        for (int cut : cutsArray) cuts.add(cut);

        cuts.add(0);
        cuts.add(n);

        Collections.sort(cuts);

        int m = cuts.size(); // includes boundaries

        dp = new int[m][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(cuts, 1, m - 2);
    }
}
