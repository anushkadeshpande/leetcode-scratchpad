const howSum = (targetSum, numbers, memo = {}) => {
    if(targetSum in memo)
        return memo[targetSum]
    if(targetSum === 0)
        return [];

    if(targetSum < 0)
        return null;

    for(let num of numbers) {
        let remainder = targetSum - num;
        let resultArr = howSum(remainder, numbers, memo)
        if(resultArr) {
            memo[targetSum] = [ ... resultArr, num ]
            return memo[targetSum]
        }
    }

    return null
}


console.log(howSum(7, [2, 3]))
console.log(howSum(7, [5, 3, 4, 7]))
console.log(howSum(7, [2, 4]))
console.log(howSum(8, [2, 3, 5]))
let startTime = Date.now()
console.log(howSum(301, [7, 14]))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)


/* 
* null
* Time Taken:  1
*/