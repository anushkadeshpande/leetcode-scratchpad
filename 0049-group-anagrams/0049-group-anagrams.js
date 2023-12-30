/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    // iterate through the list of strings
    // sort the string
    // check if sorted string is present in hashmap
    // if exists, add the current string to the array of the sorted string
    // else add a new entry in hashmap
    // join and return
    
    let stringsMap = {}
    
    for(let str of strs) {
        let sortedStr = str.split('').sort().join('')
        if(sortedStr in stringsMap) 
            stringsMap[sortedStr] = [...stringsMap[sortedStr], str]
        else
            stringsMap[sortedStr] = [str]
    }
    
    let ans = []
    
    for(let str in stringsMap) 
        ans.push(stringsMap[str])
    return ans
};