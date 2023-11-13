const kthSmallest = (arr,l,r,k) => {
    //code here
    arr.sort((a,b) => a-b)
    return arr[k-1]
}


const arr = [7, 10, 4, 3, 20, 15]
console.log(kthSmallest(arr, 0, 5, 3))