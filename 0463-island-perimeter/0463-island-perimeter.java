class Solution {
    public int perimeter(int[][] grid, int sr, int sc, int n, int m, int[][] vis) {
        if(sr < 0 || sr >= n || sc < 0 || sc >= m) {
            return 1;
        }

        if(grid[sr][sc] == 0) {
            return 1;
        }

        if(vis[sr][sc] == 2) {
            return 0;
        }
        vis[sr][sc] = 2;
        int count = perimeter(grid, sr + 1, sc, n, m, vis) + perimeter(grid, sr - 1, sc, n, m, vis) + perimeter(grid, sr, sc + 1, n, m, vis) + perimeter(grid, sr, sc - 1, n, m, vis);

        return count;
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return perimeter(grid, i, j, n, m, vis);
                }
            }
        }

        return 0;
    }
}