const getMinMax = (arr) => {
    let max = Number.MIN_VALUE
    let min = Number.MAX_VALUE

    for(let i=0;i<arr.length;i++)
    {
        max = Math.max(max, arr[i])
        min = Math.min(min, arr[i])

    }
    return [min ,max];
}


let arr = [22, 14, 8, 17, 35, 3]
console.log("Min: ", getMinMax(arr)[0], " Max: ", getMinMax(arr)[1])
