var countHomogenous = function(s) {
    
    let numSubstrings = s.length
    
    let buffer = ''
    let currentChar = ''
    for(let i = 0; i < s.length; i++) {
        // store the current character
        if(currentChar == '') {
            currentChar = s[i]
            buffer += currentChar
        }
        else {
            if(s[i] == currentChar)
            {
                buffer += currentChar
            }
            else {
                
                buffer = s[i]
                currentChar = s[i]
            }
            numSubstrings += buffer.length - 1
        }
    }
    
    return numSubstrings%1000000007
};