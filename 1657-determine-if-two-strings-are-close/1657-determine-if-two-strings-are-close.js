/**
 * @param {string} word1
 * @param {string} word2
 * @return {boolean}
 */

let getOccurrences = (string) => {
    string = string.split('')
    
    let occurrenceMap = {}
    
    for(let i=0; i<string.length; i++) {
        if(string[i] in occurrenceMap)
            occurrenceMap[string[i]] += 1
        else
            occurrenceMap[string[i]] = 1
    }
    
    return occurrenceMap
}


var closeStrings = function(word1, word2) {
    // return false if lengths of the 2 words is not equal
    // else
    // take char count of both strings
    if(word1.length !== word2.length)    
        return false
    
    let word1Chars = getOccurrences(word1)
    let word2Chars = getOccurrences(word2)
    
    if((Object.values(word1Chars).sort((a,b) => a -b).toString() === Object.values(word2Chars).sort((a,b) => a -b).toString()) && (Object.keys(word1Chars).sort().toString() === Object.keys(word2Chars).sort().toString()))
        return true
    return false

};