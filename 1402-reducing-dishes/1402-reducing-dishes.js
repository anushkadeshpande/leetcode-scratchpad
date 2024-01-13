/**
 * @param {number[]} satisfaction
 * @return {number}
 */

let getMaxSatisfaction = (satisfaction, index, time, memo={}) => {
    let key = index + '-' + time
    
    if(key in memo)
        return memo[key]
    if(index >= satisfaction.length)
        return 0
    
    // either we include a dish or exclude it
    
    // if we include it
    let includeSatisfaction = (satisfaction[index] * time) + getMaxSatisfaction(satisfaction, index+1, time+1, memo)
    
    // if we do not include it
    let excludeSatisfaction = getMaxSatisfaction(satisfaction, index+1, time, memo)
    
    memo[key] = Math.max(includeSatisfaction, excludeSatisfaction)
    
    return memo[key]
}


var maxSatisfaction = function(satisfaction) {
    // sort the satisfaction array
    satisfaction = satisfaction.sort((a, b) => a-b)
        
    // call getMaxSatisfaction
    return getMaxSatisfaction(satisfaction, 0, 1)
};