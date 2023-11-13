const countConstruct = (target, wordBank, memo = {}) => {
    if(target in memo)
        return memo[target]
    
    if(target === '')
        return 1;

    let totalCount = 0

    for(let word of wordBank) {
        if(target.indexOf(word) === 0) {
            let suffix = target.slice(word.length)
            let numWaysForRest = countConstruct(suffix, wordBank, memo)
            totalCount += numWaysForRest 
        }
    }

    memo[target] = totalCount
    return memo[target]
}


console.log(countConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); // 2
console.log(countConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // 1 
console.log(countConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // 0 
console.log(countConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); // 4 

let startTime = Date.now()
console.log(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
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
* 0
* Time Taken:  0
*/