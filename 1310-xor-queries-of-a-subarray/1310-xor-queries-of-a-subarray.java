class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        
//         for(int i=0; i<n; i++) {
//             int start = queries[i][0];
//             int end = queries[i][1];
            
//             int xor = arr[start];
//             for(int j=start+1; j<=end; j++) {
//                 xor = xor ^ arr[j];
//             }
            
//             answer[i] = xor;
//         }
        
//         return answer;
        
         /* 
         *
         *
         * BETTER SOLUTION USING PREFIX SUM
         *
         */
        
        int m = arr.length;
        int[] prefix = new int[m];
        prefix[0] = arr[0];
        for(int i=1; i<m; i++) {
            prefix[i] = prefix[i-1] ^ arr[i];
        }
        
        for(int i=0; i<n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            if(start == 0) {
                answer[i] = prefix[end];
            } else {
                // remove prefix[0] - prefix[start-1] from prefix[end]
                // this will give prefix[start] - prefix[end]
                answer[i] = prefix[start-1] ^ prefix[end];
            }
        }
        
        return answer;
    }
}