/**
 * @param {string} s
 * @return {boolean}
 */

Array.prototype.peek = function() {
    return this[0]
}

Array.prototype.push = function(item) {
    let newStack = [item, ...this]
    Object.assign(this, newStack)
    return newStack.length
}

Array.prototype.pop = function() {
    this.splice(0,1)
}

var isValid = function(s) {
    let stack = []
    
    for(let c of s.split('')) {
        // console.log(stack)
        // push opening char in stack
        if(c === '(' || c === '[' || c === '{') {
            stack.push(c)
        }
        
        // else if closing char is found, peek the stack
        // if the opening bracket matches the current closing one, pop it from stack
        // else return false
        else {
            if(c === ')')
                if(stack.peek() === '(')
                    stack.pop()
                else 
                    return false
            else if(c === ']') 
                if(stack.peek() === '[')
                    stack.pop()
                else
                    return false
            else if(c === '}')
                if(stack.peek() === '{')
                    stack.pop()
                else
                    return false
        }
    }
    
    // if stack is empty, return true
    // else return false
    if(stack.length === 0)
        return true
    else
        return false
};