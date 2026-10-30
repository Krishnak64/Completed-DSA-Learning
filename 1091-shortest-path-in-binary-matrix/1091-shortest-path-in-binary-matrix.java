class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        int[][] dist = new int[n][n];

        for(int row[]: dist) {
            Arrays.fill(row, 0);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        int  directions[][] = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            if(row == n-1 && col == n-1) {
                return dist[row][col];
            }

            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < n &&
                grid[newRow][newCol] == 0 &&
                dist[newRow][newCol] == 0) {
                    dist[newRow][newCol] = dist[row][col] + 1;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return -1;
    }
}