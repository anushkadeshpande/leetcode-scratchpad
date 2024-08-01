class Solution {
    public int countSeniors(String[] details) {
        // int count = 0;
        
        // 1. substring : faster than 82.65
        // for(String detail: details) {
        //     if(Integer.parseInt(detail.substring(11, 13)) > 60)
        //         count++;
        // }
        // return count;
        
        
        // 2. Stream, even slower, 11.44
        // return (int)Arrays.stream(details).filter(detail -> Integer.parseInt(detail.substring(11, 13)) > 60).count();
        
        
        // 3. charAt   ----- fastest
        int count = 0;
        for(String detail: details) {
            if((((detail.charAt(11) - '0') * 10) + (detail.charAt(12) - '0')) > 60)
                count++;
        }
        return count;
        
    }
}