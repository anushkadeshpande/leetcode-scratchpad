/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    let cache = {}
    return function(...args) {
        let key = JSON.stringify(args)
        let result = null
        if(key in cache)
            result = cache[key]
        else {
            result = fn(...args)
            cache[key] = result
        }
        
        return result
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */