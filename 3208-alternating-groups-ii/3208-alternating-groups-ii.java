class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int maxLength = 1;
        int count = 0;
        int n = colors.length;
        
        for(int i=1; i<=n-1+k-1; i++) {
            if(colors[i%n] != colors[(i-1+n)%n])
                maxLength++;
            else
                maxLength = 1;
            
            if(maxLength >= k)
                count++;
        }
        
        return count;
    }
}