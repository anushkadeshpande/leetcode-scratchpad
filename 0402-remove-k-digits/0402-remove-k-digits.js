/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function(num, k) {
    let stack = []
    let i = 0
    
    for(let c of num) {
        while( stack.length != 0 && c < stack[stack.length - 1] && k > 0) {
            // stack.push(num.charAt(i))
            stack.pop()
            k--
        }
        
        stack.push(c)
    }
    // if some chars are yet to be removed
    while(k > 0) {
        stack.pop()
        k--
    }
    
    
    let res = ""
    
    // construct result string
    while(stack.length != 0) {
        res += stack.pop()
    }
    
    res = res.split('').reverse().join('')
    let idx = 0
    // remove any leading zeroes
    for(i=0; i<res.length; i++) {
        if(res.charAt(i) != '0') {
            idx = i
            break
        }
    }
    
    res = res.substr(i, res.length + 1)
    
    return res === ""? "0" : res
};