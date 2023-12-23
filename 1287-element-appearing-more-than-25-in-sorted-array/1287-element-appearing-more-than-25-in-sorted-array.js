/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function(arr) {
    let occurenceCount = {}
    for(let num of arr) {
        if(occurenceCount[num])
            occurenceCount[num] += 1
        else
            occurenceCount[num] = 1
    }
    
    for(let num in occurenceCount) {
        if(((occurenceCount[num]/arr.length) * 100) > 25)
            return num
    }
};