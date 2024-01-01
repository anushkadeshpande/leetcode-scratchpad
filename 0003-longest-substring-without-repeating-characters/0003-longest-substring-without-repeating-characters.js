/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
  let i = 0
  let j = 0
  let maxLength = 1
  let addedChars = new Set();
  if(s == "")
      return 0
  if(s.length == 1)
      return 1
  while (j < s.length) {
      if(!addedChars.has(s.charAt(j))) {
          addedChars.add(s.charAt(j))
          j++
          maxLength = Math.max(maxLength, addedChars.size)
      }
      else {
          addedChars.delete(s.charAt(i))
            i++ 
      }
      
  }
    
    return maxLength
};