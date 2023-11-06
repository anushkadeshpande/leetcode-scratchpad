/**
 * @param {number[]} nums
 * @return {number}
 */

var rob = function(nums) {

    let maxSum = new Array(nums+1)
    maxSum[0] = 0
    maxSum[1] = nums[0]
    
    for(let i=1;i<nums.length; i++) {
        maxSum[i+1] = Math.max(maxSum[i], maxSum[i-1] + nums[i])
    }
    
    return maxSum[nums.length]
};