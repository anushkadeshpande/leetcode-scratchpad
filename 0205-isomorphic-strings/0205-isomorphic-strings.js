/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
    let charMap = new Map()
    for(let i=0; i<s.length; i++) {
        // if character is not in charmap, add it
        if(!charMap.has(s.charAt(i)) && !(Array.from(charMap.values())).includes(t.charAt(i))) 
            charMap.set(s.charAt(i), t.charAt(i))
        else {
            // return false if the mapping does not match
            if(charMap.get(s.charAt(i)) !== t.charAt(i))
                return false
        }
        
    }
    
    return true
};