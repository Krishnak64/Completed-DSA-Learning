class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    // up
                    if(i > 0 && grid[i-1][j] == 0 || i==0) {
                        perimeter += 1;
                    }
                    // left
                    if(j > 0 && grid[i][j-1] == 0 ||j==0) {
                        perimeter += 1;
                    }

                    // down
                    if(i < n - 1 && grid[i+1][j] == 0 || i==n-1) {
                        perimeter += 1;
                    }
                    // right
                    if(j < m - 1 && grid[i][j+1] == 0 || j == m - 1) {
                        perimeter += 1;
                    }
                }
            }
        }
        return perimeter;
    }
}