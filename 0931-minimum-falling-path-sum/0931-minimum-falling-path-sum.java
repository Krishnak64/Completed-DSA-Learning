class Solution {
    static int rec(int i, int j, int n, int m, int matrix[][], int dp[][]) {
        if(i == n-1) { // ------- last row ------
            return matrix[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        // ----------- choices -------

        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        down = matrix[i][j] + rec(i+1, j, n, m, matrix,dp);

        if(j + 1 < m) {
            right = matrix[i][j] + rec(i+1, j+1, n, m, matrix, dp);
        }

        if(j-1 >= 0) {
            left = matrix[i][j] + rec(i+1, j - 1, n, m, matrix, dp);
        }

        return dp[i][j] = Math.min(down, Math.min(left, right));

    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        //dp table to store the min falling path sum
        int dp[][] = new int[n][m];

        //initialize the first row of dp table with the r\first row of matrox
        for(int j=0;j<m;j++) {
            
            dp[0][j] = matrix[0][j];
        }

         //filling dp table
         for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                //initialize the min sum to the value directly above

                int minSum = dp[i-1][j];

                //check left diagonal(if exists)

                if(j - 1 >= 0) {
                 minSum = Math.min(minSum, dp[i-1][j-1]);
                 }

                //checking  right diagonal (if exist)
                if(j + 1 < m) {
                    minSum = Math.min(minSum, dp[i-1][j+1]);
                }

                //update the currrnt cell in the dp table

                dp[i][j] = matrix[i][j] + minSum;
            }
         }
         //find the min val in the last row of dp table
            int result = Integer.MAX_VALUE; 
            for(int j=0;j<m;j++) {
                result = Math.min(result, dp[n-1][j]);
            }

            return result;
        
    }
}