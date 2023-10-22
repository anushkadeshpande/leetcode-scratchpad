const fibonacciRecursive = (n, memo = {}) => {
    if(n in memo) 
        return memo[n]
    if(n <= 2)
        return 1
    memo[n] = fibonacciRecursive(n-1, memo) + fibonacciRecursive(n-2, memo)

    return memo[n]
}

let startTime = Date.now() 
console.log(fibonacciRecursive(50))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)
/*
* 12586269025
* Time Taken:  4
*/