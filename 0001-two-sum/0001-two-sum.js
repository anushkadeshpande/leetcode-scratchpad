/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let numbersWanted = {}

    for(let i =0; i<nums.length; i++) {
        const res = target - nums[i]
        if(Object.keys(numbersWanted).includes(String(nums[i])))
            return [i, numbersWanted[nums[i]]]
        else
            numbersWanted[res] = i
    }
};