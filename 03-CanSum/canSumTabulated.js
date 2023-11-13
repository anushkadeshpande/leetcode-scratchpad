const canSum = (targetSum, numbers) => {
    const table = Array(targetSum + 1).fill(false)

    table[0] = true

    for(var i = 0; i < targetSum; i++) {
        if(table[i] === true)
        for(let number of numbers) {
            if( i + number <= table.length) {
                table[i + number] = true 
            }
        }
    }

    return table[targetSum]
}

console.log(canSum(7, [2, 3])) // true
console.log(canSum(7, [5, 3, 4, 7])) // true
console.log(canSum(7, [2, 4])) // false
console.log(canSum(8, [2, 3, 5])) // true

let startTime = Date.now()
console.log(canSum(300, [7, 14]))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)


/* 
* false
* Time Taken:  0
*/