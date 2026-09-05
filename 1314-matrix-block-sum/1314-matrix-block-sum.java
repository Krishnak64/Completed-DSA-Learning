class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int sum = 0;

                for(int r = i - k; r <= i + k; r++) {
                    for(int c = j - k; c <= j + k; c++) {
                        if(r >= 0 && r < n && c >= 0 && c < m) {
                            sum += mat[r][c];
                        }
                    }
                }

                ans[i][j] = sum;
            }
        }
        return ans;
    }
}