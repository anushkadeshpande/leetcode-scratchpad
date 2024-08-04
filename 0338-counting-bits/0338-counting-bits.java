class Solution {
    public int[] countBits(int n) {
        int count = 0;
        int[] result = new int[n+1];
        
        for(int i=0; i<=n; i++) {
            count = 0;
            int temp = i;
            while(temp != 0) {
                if(temp % 2 != 0)
                    count ++;
                temp = temp >> 1;
            }
            
            result[i] = count;
        }
        
        return result;
    }
}