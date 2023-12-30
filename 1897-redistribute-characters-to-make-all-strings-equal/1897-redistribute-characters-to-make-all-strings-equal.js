/**
 * @param {string[]} words
 * @return {boolean}
 */
var makeEqual = function(words) {
    
    // find total number of chars in words
    // if num chars % length(words) != 0, return false
    // else
    // find occurrences of each character, if all of them % len(words) === 0
    // return true
    // else return false
    
    let allChars = words.join('')
    let totalChars = allChars.length
    
    if(totalChars % words.length !== 0)
        return false
    else {
        let charMap = {}
        for(let char of allChars) {
            if(char in charMap)
                charMap[char] += 1
            else
                charMap[char] = 1
        }
        
        for(let char in charMap) {
            if(charMap[char] % words.length !== 0)
                return false
        }
        return true
    }
};