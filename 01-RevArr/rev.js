const reverse = (arr) => {
    let revArr = []
    for(let i=arr.length - 1; i>= 0 ; i--) {
        revArr.push(arr[i])
    }
    return revArr
}

console.log(reverse([4, 5, 1, 2]))