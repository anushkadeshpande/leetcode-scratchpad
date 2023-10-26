const allConstruct = (target, wordBank) => {
    if(target === '')
        return [[]]

    let result = []

    for(let word of wordBank) {
        if(target.indexOf(word) === 0) {
            let suffix = target.slice(word.length)
            let suffixWays = allConstruct(suffix, wordBank)
            let targetWays = suffixWays.map(way => [word, ...way])
            result.push(...targetWays)
        }
    }

    return result
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
* Time Taken:  Infinity
*/