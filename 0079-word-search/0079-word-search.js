/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */


var exist = function(board, word) {
    // we'll have to maintain the visited path, so that we do not end up visiting the same node twice
    // using DFS, we can find the path
    const rows = board.length
    const cols = board[0].length
    let visited = new Array(rows).fill(null).map(() => new Array(cols).fill(false));

    let dfs = (row, col, i) => {
        // we find the word
        if(i === word.length)
            return true
        
        // 0 <= row <= rows
        // 0 <= col <= cols
        // the current box does not contain the desired alphabet
        // the current position should not be already visited
        if(row < 0 || row >= rows || col < 0 || col >= cols || word.charAt(i) !== board[row][col] || visited[row][col])
            return false
        
        // if we reach here, the current position is correct, and can be added to path
        visited[row][col] = true
        
        // move!!!
        let result = (dfs(row + 1, col, i+1) || dfs(row - 1, col, i + 1) || dfs(row, col + 1, i + 1) || dfs(row, col - 1, i + 1))
        
        // remove current node from path
        visited[row][col] = false
        return result
        
    }
    
    for(let i=0; i<rows; i++) {
        for(let j=0; j<cols; j++) {
            // for every alphabet in the grid, call dfs
            if(dfs(i, j, 0))
                return true
        }
    }
    
    return false
};