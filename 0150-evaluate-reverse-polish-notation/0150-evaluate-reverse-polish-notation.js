/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    // operands stack
    let operands = []
    
    for(let token of tokens) {
        if(token !== "+" && token !== "-" && token !== "*" && token !== "/"){
            operands.push(token)
        }
        
        else {
            let operand1 = operands.pop()
            let operand2 = operands.pop()
            operands.push(Math.trunc(eval("(" + operand2 + ")" + token + "(" + operand1 + ")")))
        }
    }
    
    return operands.pop()
};