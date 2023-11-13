/**
 * @param {string} s
 * @return {number}
 */

let isNumber = (c) => {
    return [1, 2, 3, 4, 5, 6, 7, 8, 9, 0].includes(+c)
}

var myAtoi = function(s) {
    let sign = ''
    let num = ''
    
    // remove all whitespaces
    s = s.trimLeft()
    
    // check if the 1st character is + or -
    // and then strip it off from the string
    if(s.charAt(0) === '+' || s.charAt(0) === '-') {
        sign = s.charAt(0)
        s = s.slice(1)
    }
    
    for(let c of s) {
        if(c === ' ')
            break
        else if(!isNaN(Number(c))) {
            num += c
        }
        else
            break
    }
        
    if(isNaN(num) || num === '')
        return 0
    num = +(sign+num)

    if(num < Math.pow(-2, 31))
        return Math.pow(-2, 31)
    else if(num > (Math.pow(2, 31) - 1))
        return (Math.pow(2, 31) - 1)
    return num
};