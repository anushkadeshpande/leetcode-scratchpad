const howSum = (targetSum, numbers) => {
  const table = Array(targetSum + 1).fill(null);

  table[0] = [];

  for (var i = 0; i < targetSum; i++) {
    if (table[i])
      for (let number of numbers) {
        table[i + number] = [...table[i], number];
      }
  }

  return table[targetSum];
};

console.log(howSum(7, [2, 3]));   // [ 3, 2, 2 ]
console.log(howSum(7, [5, 3, 4, 7]));    // [ 4, 3 ]
console.log(howSum(7, [2, 4]));    // null
console.log(howSum(8, [2, 3, 5]));    // [ 2, 2, 2, 2 ]
let startTime = Date.now(); 
console.log(howSum(300, [7, 14]));
let endTime = Date.now();

console.log("Time Taken: ", endTime - startTime);

/*
 * null
 * Time Taken:  0
 */
