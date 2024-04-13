/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    let start = 0
    let end = k
    
    // find sum of the window
    let sumOfKNum = nums.slice(start, end).reduce((acc, num) => acc + num, 0)
    let maxAvg = sumOfKNum / k
        
    while(end < nums.length) {
        // subtract nums[start] and add nums[end + 1] to sum 
        sumOfKNum = sumOfKNum - nums[start] + nums[end]
        
        // find maxAvg
        maxAvg = Math.max(maxAvg, sumOfKNum/k)
        
        start++
        end++
    }
    
    return maxAvg
};