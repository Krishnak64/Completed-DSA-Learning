class Solution {
    public int allUniquePath(int grid[][], int sr, int er, int sc, int ec, int[][] dp) {
        if(sr > er || sc > ec) {
            return 0;
        }

        if(grid[sr][sc] == 1) {
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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return allUniquePath(obstacleGrid, 0, m - 1, 0, n - 1, dp);
    }
}