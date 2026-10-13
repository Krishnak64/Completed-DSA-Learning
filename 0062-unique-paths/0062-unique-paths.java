class Solution {
    public int allUniquePath(int grid[][], int sr, int er, int sc, int ec, int[][] dp) {
        if(sr > er || sc > ec) {
            return 0;
        }

        if(sr == er && sc == ec) {
            return 1;
        }
        
        if(dp[sr][sc] != -1) {
            return dp[sr][sc];
        }

        // move down
        int count1 = allUniquePath(grid, sr+1, er, sc, ec, dp);
        // move right
        int count2 = allUniquePath(grid, sr, er, sc + 1, ec, dp);

        // total
        int c = count1 + count2;
        dp[sr][sc] = c;
        
        return c;
    }
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return allUniquePath(grid, 0, m - 1, 0, n - 1, dp);
    }
}