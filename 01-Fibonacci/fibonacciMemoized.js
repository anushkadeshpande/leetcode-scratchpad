const fibonacciMemoized = (n, memo = {}) => {
    if(n in memo) 
        return memo[n]
    if(n <= 2)
        return 1
    memo[n] = fibonacciMemoized(n-1, memo) + fibonacciMemoized(n-2, memo)

    return memo[n]
}

let startTime = Date.now() 
console.log(fibonacciMemoized(50))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)
/*
* 12586269025
* Time Taken:  4
*/