/**
 * @param {string} s
 * @return {number}
 */
var maxLengthBetweenEqualCharacters = function(s) {
  let j = 0
  let maxLength = -1
  let lengthByChar = {}
  for(let k=0; k<s.length; k++) {
      j = k + 1
      while(s.charAt(j) != s.charAt(k) && j <= s.length-1)
          j++
      
      // if matching char is found
      if(s.charAt(k) == s.charAt(j)) {
        if(s.charAt(k) in lengthByChar)
          lengthByChar[s.charAt(k)] += j - k
        else
          lengthByChar[s.charAt(k)] = j - k - 1
          maxLength = Math.max(maxLength, lengthByChar[s.charAt(k)])
      }
  }   
  
  return maxLength
};
