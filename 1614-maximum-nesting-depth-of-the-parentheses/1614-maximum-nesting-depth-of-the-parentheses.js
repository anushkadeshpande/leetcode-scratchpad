/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    let length = 0
    let maxLength = 0
    s = s.split('')
    for(let char of s) {
        if(char === '(') {
            length++
            maxLength = Math.max(maxLength, length)
        } else if(char === ')') {
            length--
        }
    }
    
    return maxLength
};