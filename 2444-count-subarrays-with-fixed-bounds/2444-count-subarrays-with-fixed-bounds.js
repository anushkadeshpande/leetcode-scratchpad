/**
 * @param {number[]} nums
 * @param {number} minK
 * @param {number} maxK
 * @return {number}
 */
var countSubarrays = function(nums, minK, maxK) {
    
    // position of minK
    // position of maxK
    // record valid window start position
    
    // for every element in the array, check the window, update it if required
    // check if current element is problematic
    // consider the current index as ending index of subarray 
    let posMinK = -1
    let posMaxK = -1
    let posProblematicK = -1
    
    let res = 0
    
    for(let i=0; i<nums.length; i++) {
        if(nums[i] < minK || nums[i] > maxK)
            posProblematicK = i
        
        if(nums[i] === minK)
            posMinK = i
        
        if(nums[i] === maxK)
            posMaxK = i
        
        // to calculate starting point of valid window
        let minOfPos = Math.min(posMinK, posMaxK)
        
        // minOfPos - posProblematicK ----- if this is negative, it indicates that the problematic element is inside the window right now, and hence the current window is invalid and should be excluded
        // if, another window exists beyond the problematic point, the diff will be +ve and we can take count from there
        res += (minOfPos - posProblematicK <= 0) ? 0 : (minOfPos - posProblematicK)
        
    }
    
    return res
};