/**
 * @param {number} x
 * @return {number}
 */
var sumOfTheDigitsOfHarshadNumber = function(x) {
    let digitSum = 0
    let n = x
    while(n != 0) {
        digitSum += Math.floor(n%10)
        n = Math.floor(n / 10)
    }
    
    return x % digitSum === 0 ? digitSum : -1
};