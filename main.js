/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */

let cleanCharMap = (charMap) => {
  // remove chars with count <= 0
  charMap = Object.fromEntries(
      Object.entries(charMap).filter(([char]) => charMap[char] > 0)
  );
  
  return charMap
} 

let getCompressedStringLength = (charMap) => {
  // length of original compressed string
  let lengthOfOgCompressedString = 0
  
  charMap = cleanCharMap(charMap)
  
  for(let char in charMap) {
      lengthOfOgCompressedString += 1
      if(charMap[char] > 1)
          lengthOfOgCompressedString += charMap[char].toString().length
  }
  
  return lengthOfOgCompressedString
}

let getCompressedString = (charMap) => {
  let str = ""
  for(let char in charMap) {
    str += char
    if(charMap[char] > 1)
        str += charMap[char].toString()
}

return str
}

let removeKCharacters = (char, charMap, k, memo = {}) => {
  // console.log("\n\nInside removeKCharacters fn")
  // console.log("Removing ", char, "and still need to remove ", k-1)
  let key = getCompressedString(charMap) + "-" + char + "-" + k
  // console.log(key)
  
  if(key in memo)
      return memo[key]
  
  if(k === 0) {
      // charMap[char] -= 1
      memo[key] = getCompressedStringLength(charMap)
      return memo[key]
  }

  charMap[char] -= 1
  
  charMap = cleanCharMap(charMap)
  let len = getCompressedStringLength(charMap);
  // let len = 0
  
  for(let c in charMap) {
    // console.log("\nInside the loop in fn")
    // console.log("After removing ", char, "charMap looks like: ", charMap)
    // console.log("Proceeding to remove ", c)
    // let newKey = c + ":" + Math.max(0, k - (c === char ? 0 : 1))
    // console.log(newKey)
      len = Math.min(removeKCharacters(c, {...charMap}, k-1, memo), len)
  }

  charMap[char] += 1

  memo[key] = len
  return memo[key]
}

var getLengthOfOptimalCompression = function(s, k) {
  // count consecutive chars and create compressed string (in a hashmap)
  let occurrencesMap = {}
  s = s.split('')
  for(let c of s) {
      if(c in occurrencesMap)
          occurrencesMap[c] += 1
      else
          occurrencesMap[c] = 1
  }
  

  let minLength = getCompressedStringLength(occurrencesMap)

  let len = minLength
  if(k === 0)
    return minLength
  // if none of the characters are repeated
  else if(minLength === s.length)
    return minLength - k
  for(let char in occurrencesMap) {
      len = Math.min(removeKCharacters(char, {...occurrencesMap}, k), len)
  }
  
  return len
  
};
