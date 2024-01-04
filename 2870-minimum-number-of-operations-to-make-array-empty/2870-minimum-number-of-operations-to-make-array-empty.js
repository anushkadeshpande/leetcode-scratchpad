/**
 * @param {number[]} nums
 * @return {number}
 */


var minOperations = function(nums) {
  // frequencies of each element 2 || 3 --> possible
  // maybe get frequencies of all in an object
  // if any of the frequencies % 2 || % 3 != 0
  // return -1
  // else
  // loop through the object
  
  let frequencies = {}
  let numOperations = 0
  for(let i=0; i<nums.length; i++) {
      if(nums[i] in frequencies)
          frequencies[nums[i]] ++
      else
          frequencies[nums[i]] = 1
  }
  
  
  for(let num in frequencies) {
      if(frequencies[num] === 1)
          return -1
      if(frequencies[num]%3 === 0)
          numOperations += frequencies[num]/3
      else if(frequencies[num] > 3) {
          let remaining = frequencies[num]%3
          if(remaining % 2 === 0)  
              numOperations += Math.floor(frequencies[num]/3) + (remaining / 2)
          else 
              numOperations += (Math.floor(frequencies[num]/3) - 1) + (((frequencies[num]%3) + 3) / 2)
        }
      else if(frequencies[num] % 2 === 0)
          numOperations += frequencies[num]/2
      
  }
  
  return numOperations
};

