class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudokuState = new HashSet<>();
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    // check if set has the element
                    if(!sudokuState.add(board[i][j] + " in row " + i) || !sudokuState.add(board[i][j] + " in col " + j) || !sudokuState.add(board[i][j] + " in box " + i/3 + " : " + j/3))
                        return false;
                    
                }
            }
        }
        
        return true;
    }
}