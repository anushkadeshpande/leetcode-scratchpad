var TimeLimitedCache = function() {
    cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    let keyStatus = false
    if(cache.has(key)) {
        keyStatus = true
        
        // clear the previous timeout
        clearTimeout(cache.get(key).timer)
    }
        
    cache.set(key, {value: value, timer: setTimeout(() => cache.delete(key), duration)})
    
    
    
    return keyStatus
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    return cache.get(key)? cache.get(key).value : -1
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return cache.size
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */