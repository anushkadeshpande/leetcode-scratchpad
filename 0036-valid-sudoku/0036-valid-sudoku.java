class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudokuState = new HashSet<>();
        
        for(int i=0; i<board[0].length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] != '.') {
                    // check if set has the element
                    if(sudokuState.contains(board[i][j] + " in row " + i) || sudokuState.contains(board[i][j] + " in col " + j) || sudokuState.contains(board[i][j] + " in box " + i/3 + " : " + j/3))
                        return false;
                    
                    else {
                        sudokuState.add(board[i][j] + " in row " + i);
                        sudokuState.add(board[i][j] + " in col " + j);
                        sudokuState.add(board[i][j] + " in box " + i/3 + " : " + j/3);
                    }
                }
            }
        }
        
        return true;
    }
}