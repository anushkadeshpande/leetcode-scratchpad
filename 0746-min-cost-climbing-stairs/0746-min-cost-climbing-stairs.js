/**
 * @param {number[]} cost
 * @return {number}
 */

let climb = (costArr, idx, memo = {}) => {
    if(idx in memo)
        return memo[idx]
    if(idx >= costArr.length)
        return 0;
    let oneStepCost = costArr[idx] + climb(costArr, idx + 1, memo)
    let twoStepCost = costArr[idx] + climb(costArr, idx + 2, memo)
    
    memo[idx] = Math.min(oneStepCost, twoStepCost)
    return memo[idx]
}

var minCostClimbingStairs = function(cost) {
    
    return Math.min(climb(cost, 0), climb(cost, 1))
};
