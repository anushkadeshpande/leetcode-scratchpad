/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    let validSet = new Set()
    for(let i = 0; i < 9; i++) {
        for(let j = 0; j < 9; j++) {
            // check cols
            // check boxes (3 * 3)
            // check rows
            // console.log(validSet)
            if(board[i][j] !== '.') {
                if(validSet.has(board[i][j] + " in row " + i) || 
                  validSet.has(board[i][j] + " in col " + j) || 
                  validSet.has(board[i][j] + " in box " + Math.floor(i/3) + ":" + Math.floor(j/3)))
                return false
                validSet.add(board[i][j] + " in row " + i)    
                validSet.add(board[i][j] + " in col " + j)    
                validSet.add(board[i][j] + " in box " + Math.floor(i/3) + ":" + Math.floor(j/3))    
            }
        }
    }
    return true
};