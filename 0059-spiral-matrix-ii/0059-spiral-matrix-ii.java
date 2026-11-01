class Solution {
     public int[][] printSpiralOrder(int n) {
        int[][] ans = new int[n][n];

        int startingRow = 0;
        int startingCol = 0;
        int endingRow = n-1;
        int endingCol = n-1;
        int no = 1;

        while(startingRow <= endingRow && startingCol <= endingCol) {
            // top
            for(int j=startingCol; j<=endingCol; j++) {
                ans[startingRow][j] = no;
                no++;
            }

            // right
            for(int i=startingRow+1; i<=endingRow; i++) {
                
                ans[i][endingCol] = no;
                no++;
            }

            // bottom

            // important condition
            if (startingRow < endingRow) { //  avoid double row printing
                for (int j = endingCol - 1; j >= startingCol; j--) {
                    ans[endingRow][j] = no;
                    no++;
                }
            }

            // left
            if (startingCol < endingCol) { //  avoid double col printing
                for (int i = endingRow - 1; i > startingRow; i--) {
                    ans[i][startingCol] = no;
                    no++;
                }
            }
            startingRow++;
            startingCol++;
            endingRow--;
            endingCol--;
        }
        return ans;
    }
    public int[][] generateMatrix(int n) {
        return printSpiralOrder(n);
    }
}