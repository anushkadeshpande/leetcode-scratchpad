/**
 * @param {string} s
 * @return {string}
 */

let isAVowel = (ch) => {
   return ['a', 'e', 'i', 'o', 'u'].includes(ch.toLowerCase());
}

var sortVowels = function(s) {
    let vowels = []
    s = s.split('');

    // extract vowels, and replace them with *
    for(let i=0; i<s.length; i++) {
        if(isAVowel(s[i])) {
            vowels.push(s[i])
            s[i] = '*'
        }
    }    
    
    // sort vowels according to ascii value
    vowels.sort((a, b) => b.charCodeAt(0) - a.charCodeAt(0));
    
    // replace * with sorted vowels
    for(let i=0; i<s.length; i++) {
        if(s[i] === '*') {
            s[i] = vowels.pop()
        }
    }

    // convert array to string and return
    return s.join('')
};