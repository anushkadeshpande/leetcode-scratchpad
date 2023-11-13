const fibonacci = (n) => {
    const table = Array(n+1).fill(0)
    table[1] = 1

    for(let i = 0; i <= n; i++) {
        table[i + 1] += table[i] 
        table[i + 2] += table[i]
    }

    return table[n]
}

console.log(fibonacci(6))
console.log(fibonacci(7))
console.log(fibonacci(8))

let startTime = Date.now() 
console.log(fibonacci(50))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)
/*
* 12586269025
* Time Taken:  0
*/