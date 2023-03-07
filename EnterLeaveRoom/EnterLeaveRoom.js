const calculateEnterLeaveRoom = (reqString) => {
    let maxEnterLeave = reqString.length
    let minEnterLeave = 0
    let ans = 0

    for (let i=0; i<reqString.length; i++) {
        if (reqString[i] === '1')
            minEnterLeave ++;
        else if (reqString[i] === '0')
            minEnterLeave --;

        if (minEnterLeave < 0) {
            ans ++
            minEnterLeave = 0
        }
        minEnterLeave = Math.max(minEnterLeave, ans)
    }
    console.log("Max: ", maxEnterLeave)
    console.log("Min: ", minEnterLeave)
    
}

calculateEnterLeaveRoom("010")