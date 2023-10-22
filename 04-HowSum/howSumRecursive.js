const howSum = (targetSum, numbers) => {
    if(targetSum === 0)
        return [];

    if(targetSum < 0)
        return null;

    for(let num of numbers) {
        let remainder = targetSum - num;
        let resultArr = howSum(remainder, numbers)
        if(resultArr) {
            // resultArr.push(num)
            return [ ... resultArr, num ]
        }
    }

    return null
}


console.log(howSum(7, [2, 3]))
console.log(howSum(7, [5, 3, 4, 7]))
console.log(howSum(7, [2, 4]))
console.log(howSum(8, [2, 3, 5]))
let startTime = Date.now()
console.log(howSum(300, [7, 14]))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)

/* 
* null
* Time Taken:  14044
*/