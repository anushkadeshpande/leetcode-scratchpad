/**
 * @param {string} s
 * @return {string}
 */

let swap = (element1, element2) => {
    let temp = element1
    element1 = element2
    element2 = temp
    
    return [element1, element2]
}

var maximumOddBinaryNumber = function(s) {
    // APPROACH - 2:
    // similar to quick sort
    
    s = s.split('')
    let firstZeroPos = 0
    
    for(let i = 0; i<s.length; i++) {
        if(s[i] === '1') {
            // swap with the first zero
            [s[i], s[firstZeroPos]] = swap(s[i], s[firstZeroPos])
            firstZeroPos++
        }
    }
    
    // swap last one with the last position zero
    [s[s.length - 1] , s[firstZeroPos - 1]] = swap(s[s.length - 1], s[firstZeroPos - 1])
        
    return s.join('')
};


// APPROACH - 1
// var maximumOddBinaryNumber = function(s) {
//     // get number of ones and zeroes
//     // create a string with 1 * numOfOnes-1 + 0 * numOfZeroes + 1
//     s = s.split('')
//     let numOfZeroes = 0
//     let numOfOnes = 0
//     let result = ""
//     for(let i = 0; i<s.length; i++) {
//         if(s[i] == '0')
//             numOfZeroes ++
//         else
//             numOfOnes ++
//     }
        
//     for(let i=0; i<numOfOnes-1; i++) {
//         result += '1'
//     }
    
//     for(let i=0; i<numOfZeroes; i++) {
//         result += '0'
//     }
    
//     result += '1'
    
    
//     return result
// };