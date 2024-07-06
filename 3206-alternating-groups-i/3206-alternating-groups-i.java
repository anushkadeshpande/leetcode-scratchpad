class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int i = 0;
        int n = colors.length;
        do {
            int prevIdx = (i - 1 + n) % n;
            int nextIdx = (i + 1) % colors.length;
            if(colors[prevIdx] != colors[i] && colors[prevIdx] == colors[nextIdx]) {
                count++;
                // System.out.println(prevIdx + ":" + i + ":" + nextIdx);
            }
            i = (i + 1) % colors.length;
        } while(i != 0);

        return count;
    }
}