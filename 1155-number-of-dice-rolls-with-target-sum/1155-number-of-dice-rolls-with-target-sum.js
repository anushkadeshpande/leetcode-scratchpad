/**
 * @param {number} n
 * @param {number} k
 * @param {number} target
 * @return {number}
 */

let getTarget = (targetSum, numOfDice, k, memo = {}) => {

    // dp based on numOfDice + targetSum
    let key = targetSum + "-" + numOfDice

    if(key in memo)
      return memo[key]

    if(targetSum === 0 &&  numOfDice == 0)
        return 1
    if(targetSum < 0 || numOfDice <= 0)
        return 0
    
    let ans = 0
    for(let i = 1; i <= k; i++) {
        ans = (ans + getTarget(targetSum - i, numOfDice - 1, k, memo)) % (10**9 + 7);
    }

    memo[key] = ans
    return ans
}

var numRollsToTarget = function(n, k, target) {
  return getTarget(target, n, k)
};
