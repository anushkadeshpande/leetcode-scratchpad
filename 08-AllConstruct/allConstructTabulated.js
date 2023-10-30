const allConstruct = (target, wordBank) => {
    let table = Array(target.length + 1).fill().map(() => [])

    table[0] = [[]]

    for(let i=0; i<=target.length; i++) {
        for(let word of wordBank) {
            if(target.slice(i, i + word.length) === word) {
                // adding the current substring to array
                const newCombinations = table[i].map(subArray => [...subArray, word])

                table[i + word.length].push(...newCombinations)
            }
        }
    }

    return table[target.length]
}

console.log(allConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); 
console.log(allConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); 
console.log(allConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); 
console.log(allConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); 

let startTime = Date.now()
console.log(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    'e',
    'ee',
    'eee',
    'eeee',
    'eeeee',
    'eeeeee'
])); // 0
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)

/* 
* -
* Time Taken:  Call Stack Size Exceeded
*/