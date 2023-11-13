const canConstruct = (target, wordBank) => {
  let table = Array(target.length + 1).fill(false);

  table[0] = true;

  for (let i = 0; i <= target.length; i++) {
    if (table[i]) {
      for (let word of wordBank)
        if (target.slice(i, i + word.length) === word) {
          table[i + word.length] = true;
        }
    }
  }
//   console.log(table);

  return table[target.length]
};

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
 * Time Taken: 0
 */
