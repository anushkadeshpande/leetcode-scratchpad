/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    let charsOfStringOne = s.split('').sort()
    let charsOfStringTwo = t.split('').sort()

    if(JSON.stringify(charsOfStringOne) === JSON.stringify(charsOfStringTwo))
        return true
    else
        return false
};