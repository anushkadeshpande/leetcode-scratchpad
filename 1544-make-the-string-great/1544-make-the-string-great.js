/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function(s) {
const stack = []
    for (const ch of s) {
        if (stack.length === 0) {
            stack.push(ch)
        } else {
            if (stack[stack.length -1].toUpperCase() === ch.toUpperCase() ) {
                const item = stack.pop()
                if (item === ch) {
                    stack.push(item)
                    stack.push(ch)
                }
            } else {
                stack.push(ch)
            }
        }
    }
    return stack.join("")
};

