/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    let reverseOfX = 0
    let num = x
    if(x < 0)
        return false
    if(x < 10)
        return true
    while(num != 0) {

        reverseOfX = reverseOfX * 10 + Math.floor(num % 10)
        num = Math.floor(num / 10)
    }
    
    console.log(reverseOfX)
    
    return reverseOfX == x
};