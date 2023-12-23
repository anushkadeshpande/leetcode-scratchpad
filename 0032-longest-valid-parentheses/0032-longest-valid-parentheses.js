/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    let stack = []
    stack.push(-1)
    let maxLen = 0
    
    s = s.split("")
    
    for(let i = 0; i < s.length; i++) {
        if(s[i] === '(') {
            stack.push(i)
        }
        else if(s[i] === ')'){
            stack.pop()
            if(stack.length === 0)
            {
                // push current index to signify that the string is valid so far
                stack.push(i)
            } else {
                maxLen = Math.max(maxLen, (i - stack[stack.length - 1]))
            }
        }
    }
    return maxLen;
};