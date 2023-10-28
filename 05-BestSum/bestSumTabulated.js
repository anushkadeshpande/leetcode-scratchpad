const bestSum = (targetSum, numbers) => {
    const table = Array(targetSum + 1).fill(null);
  
    table[0] = [];
  
    for (var i = 0; i < targetSum; i++) {
      if (table[i])
        for (let number of numbers) {
            let currentValue = table[i + number]
            let possibleValue = table[i]
            if(currentValue === null || currentValue?.length > possibleValue?.length + 1)
                table[i + number] = [...table[i], number];
        }
    }
  
    return table[targetSum];
  };

console.log(bestSum(7, [5, 3, 4, 7]))
console.log(bestSum(8, [2, 3, 5]))
console.log(bestSum(8, [1, 4, 5]))
let startTime = Date.now()
console.log(bestSum(100, [1, 2, 5, 25]))
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)

/* 
* [ 25, 25, 25, 25 ]
* Time Taken:  0
*/