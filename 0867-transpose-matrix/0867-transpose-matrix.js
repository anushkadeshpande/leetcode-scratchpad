/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var transpose = function(matrix) {
    let transpose = Array(matrix[0].length).fill().map(() => Array(matrix.length))
    for(let i=0; i< matrix.length; i++) {
        for(let j =0; j < matrix[0].length; j++) {
            transpose[j][i] = matrix[i][j]
        }
    }
    
    return transpose
};