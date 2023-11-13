const canConstruct = (target, wordBank) => {
    if(target === '')
        return true;

    for(let word of wordBank) {
        if(target.indexOf(word) == 0) {
            const suffix = target.slice(word.length)
            if(canConstruct(suffix, wordBank))
                return true
        }
    }

    return false
}


console.log(canConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // true 
console.log(canConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // false 
console.log(canConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); // true 

let startTime = Date.now()
console.log(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    'e',
    'ee',
    'eee',
    'eeee',
    'eeeee',
    'eeeeee'
])); // false
let endTime = Date.now() 

console.log("Time Taken: ", endTime - startTime)

/* 
* false
* Time Taken:  Infinity
*/