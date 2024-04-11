/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let current = 0
    let left = 0
    let right = nums.length - 1
    
    while(current <= right) {
        if(nums[current] == 0) {
            [nums[current], nums[left]] = [nums[left], nums[current]]
            current ++
            left ++
        } else if(nums[current] == 2) {
            [nums[current], nums[right]] = [nums[right], nums[current]]
            // current could be 1 or 0
            // if it is a zero, we might want to check the left pointer
            // current ++
            right --
        }
        else
            current ++
    }
    
    return nums
};