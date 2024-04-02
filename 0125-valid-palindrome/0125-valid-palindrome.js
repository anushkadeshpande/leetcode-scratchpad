/**
 * @param {string} s
 * @return {boolean}
 */

let isAlphaNumeric = (c) => {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }

var isPalindrome = function(s) {
    let startPointer = 0;
    let endPointer = s.length -1;
        
        while(startPointer < endPointer) {
            
            if(!isAlphaNumeric(s.charAt(startPointer))) 
                startPointer ++;
            else if(!isAlphaNumeric(s.charAt(endPointer)))
                endPointer--;
            else if(s.charAt(startPointer).toLowerCase() != s.charAt(endPointer).toLowerCase())
                return false;
            
            else {
                startPointer ++;
                endPointer --;
            }
        }
        
        return true;
    

};