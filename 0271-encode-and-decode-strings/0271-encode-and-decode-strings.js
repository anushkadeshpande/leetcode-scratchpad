class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs) {
         // for every string in strs,
        // 1. count the number of characters
        // 2. create a string like - {num_of_chars} + ":" + {original_string}
        let encodedString = "";
        for(let str of strs) {
            encodedString += str.length;
            encodedString += ":";
            encodedString += str;
        }

        return encodedString;
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str) {
        // read from 1st char to ":", that is the number of chars in 1st string
        // push it in the list
        // do this till end of string
        let originalArray = new Array()
        let count = ''
        for(let i=0;i<str.length;i++) {
            if(str.charAt(i) === ':') {
                let s = ''
                let j = 0
                for(j = i+1; j< i+(+count)+ 1; j++) {
                    s += str.charAt(j)
                }
                originalArray.push(s)
                i = i + (+count)
                count = 0
            } else{
                count += str.charAt(i);
            }
            
        }
        return originalArray;
    }
}
