class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            int xor = arr[start];
            for(int j=start+1; j<=end; j++) {
                xor = xor ^ arr[j];
            }
            
            answer[i] = xor;
        }
        
        return answer;
    }
}