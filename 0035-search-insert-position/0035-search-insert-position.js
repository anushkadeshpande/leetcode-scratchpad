/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    let index = nums.indexOf(target)
    if(index !== -1)
        return index
    else
        return [...nums, target].sort((a, b) => a -b).indexOf(target)
};