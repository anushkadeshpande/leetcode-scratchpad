/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
    // * could be ( or ) or ""
    // how to decide what should * be replaced with?? 
    
    let stack = []
    let asterixStack = []
    
    for(let i=0; i< s.length; i++) {
        if(s.charAt(i) === '(') {
            stack.push(i)
        } else if(s.charAt(i) === '*') {
            asterixStack.push(i)
        } else {
            if(stack.length > 0) {
                stack.pop()
            } else if(asterixStack.length > 0){
                // asterix acts as an opening brace
                asterixStack.pop()
            } else 
                return false
        }
    }
    
    // check if stack is empty
    while(stack.length > 0 && asterixStack.length > 0) {
        if(stack[stack.length - 1] > asterixStack[asterixStack.length - 1])
            return false
        stack.pop()
        asterixStack.pop()
    }
    
    return stack.length === 0? true : false
};