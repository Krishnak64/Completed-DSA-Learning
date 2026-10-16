class Solution {
    static int count = 0;
    public static boolean isSafe(char [][] board, int row, int col){
        //vertical up
        for(int i=row-1,j=col;i>=0;i--){
        if(board[i][j] == 'Q'){
            return false;
        }
        }

        //diagonal left up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
        if(board[i][j] == 'Q'){
            return false;
        }
        }

        //diagonal right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
        if(board[i][j] == 'Q'){
            return false;
        }
        }
        return true; //if all the above conditions are false then we can place the queen
    }
    static void solveNQueens(char [][] board,int row){ // T.C --> O(n!)
        //base case
        if(row==board.length){
            count++;
            return;
        }
        //recursive call
        for(int j=0;j<board.length;j++){
        if(isSafe(board, row, j)==true){ //check if we can place the queen
            board[row][j] = 'Q'; //place queen
            solveNQueens(board, row+1); //call for next row
            board[row][j] = 'x'; //backtrack(it use to remove the queen)
            //if we don't remove the queen then it will be placed in the next row
        }
        }
    }
    public int totalNQueens(int n) {
      count = 0;
      char [][] board = new char[n][n];
      //initialize the board with 'x'
      for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              board[i][j] = 'x';
          }
      }
      //call the function
      solveNQueens(board, 0);
      return count;
    }
}