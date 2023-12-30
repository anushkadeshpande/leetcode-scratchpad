/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
    let occurrenceMap = {}
  for(let i=0; i<nums.length; i++) {
      if(nums[i] in occurrenceMap)
          return true
        occurrenceMap[nums[i]] = 1
  }  
  return false
};