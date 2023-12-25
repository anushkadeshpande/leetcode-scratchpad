/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    
    let zeroPositions = []
    
    // get all positions with value zero
    for(let i = 0; i<matrix.length; i++) {
        for(let j=0; j<matrix[0].length; j++){
            if(matrix[i][j] === 0) {
                zeroPositions.push([i, j])
            }
        }    
    }
    
    // for every point in position array, set rows and cols as zero
    for(let zeroPoint of zeroPositions) {
        // set the row to 0
        for(let i=0; i<matrix[0].length; i++)
            matrix[zeroPoint[0]][i] = 0
        for(let i=0; i<matrix.length; i++)
            matrix[i][zeroPoint[1]] = 0
    }
};