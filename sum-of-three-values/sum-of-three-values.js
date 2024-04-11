export function findSumOfThree(nums, target) {
    let start = 0
    let end = nums.length - 1
    
    // sort the array
    nums = nums.sort((a,b) => a - b)

    for(let i=0; i<nums.length; i++) {
        start = i + 1
        end = nums.length - 1
        while(start < end) {
            if(nums[i] + nums[start] + nums[end] === target)
                return true
            else if(nums[i] + nums[start] + nums[end] < target) {
                start ++
            } 
            else 
                end --
        }
    }

    
    return false
}
