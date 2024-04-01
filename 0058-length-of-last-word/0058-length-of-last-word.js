/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
 return s.split(" ").filter(s => s.length >= 1).pop().length 
};