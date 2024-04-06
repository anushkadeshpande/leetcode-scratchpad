/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    let stack = [] // to track correctness of paranthesis
    
    let validString = ""
    
    let trailingClosingBraces = 0
    
    for(let i=0; i<s.length; i++) {
       
        if(s.charAt(i) == '(') {
            // record the position of opening brace
            stack.push(i)
            
            // replace the opening brace in the string with -, to remember that there is an opening brace here
            validString += "-"
        }
        else if(s.charAt(i) == ')') {
            let correspondingOpening = stack.pop()
            
            if(null!= correspondingOpening)
                validString = validString.substring(0, correspondingOpening-trailingClosingBraces) + '(' + validString.substring(correspondingOpening+1-trailingClosingBraces) + ')'
            else
                trailingClosingBraces ++
            
        }
        else 
            validString += s.charAt(i)
    }
    
    // remove any extra - in the string
    validString = validString.replace(new RegExp('-', 'g'),"")
    
    return validString
};