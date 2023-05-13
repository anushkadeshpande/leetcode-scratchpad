const reverse = (arr) => {
    let i = 0
    let j = arr.length - 1

    while(i < j) {
        [arr[i], arr[j]] = [arr[j], arr[i]]
        i++;
        j--;
    }

    return arr
}

console.log(reverse([4, 5, 1, 2]))