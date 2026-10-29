class Solution {
    public void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 100;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(n == 0 || m == 0) {
            return 0;
        }

        if(n == 1 || m == 1) {
            return 0;
        }

        for(int i=0; i<n; i++) { // traversaling first and last col
            if(grid[i][0] == 1) {
                dfs(grid, i, 0);
            }

            if(grid[i][m-1] == 1) {
                dfs(grid, i, m-1);
            }
        }

        for(int i=0; i<m; i++) { // traversaling first and last row
            if(grid[0][i] == 1) {
                dfs(grid, 0, i);
            }

            if(grid[n-1][i] == 1) {
                dfs(grid, n-1, i);
            }
        }

        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count++;
                }
            }
        }

        return count;
    }
}