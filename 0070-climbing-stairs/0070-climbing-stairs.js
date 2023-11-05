/**
 * @param {number} n
 * @return {number}
 */

let climb = (numStairs, memo = {}) => {
    if(numStairs in memo)
        return memo[numStairs]
    
    if(numStairs === 0)
        return 1
    if(numStairs < 0)
        return 0;
    
    let totalStepsToTake = 0
    if(numStairs - 1 in memo)
        totalStepsToTake += memo[numStairs - 1]
    else 
        totalStepsToTake += climb(numStairs - 1, memo)

    
    if(numStairs - 2 in memo)
        totalStepsToTake += memo[numStairs - 2]
    else 
        totalStepsToTake += climb(numStairs - 2, memo)

    memo[numStairs] = totalStepsToTake
    return memo[numStairs]
}

var climbStairs = function(n) {
//     from each step, we can go either 1 step or 2 steps
   return climb(n)

};