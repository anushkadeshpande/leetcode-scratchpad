const fibonacciRecursive = (n) => {
    if(n <= 2)
        return 1
    return fibonacciRecursive(n-1) + fibonacciRecursive(n-2)
}

let startTime = Date.now() 
console.log(fibonacciRecursive(50))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)
/*
* 12586269025
* Time Taken:  86187
*/