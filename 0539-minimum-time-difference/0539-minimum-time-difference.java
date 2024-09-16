class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int minDiff = Integer.MAX_VALUE;
        int n = timePoints.size();
        List<Integer> time = new ArrayList<>();
        for(String timeString: timePoints) {
            int hh = Integer.valueOf(timeString.split(":")[0]);
            int mm = Integer.valueOf(timeString.split(":")[1]);
            if(hh == 00)
                hh = 24;
            int minutes = mm + ( 60 * hh); 
            time.add(minutes);
        }
        
        // time.sort();
        Collections.sort(time);
        
        for(int i=1; i<n; i++) {
            minDiff = Math.min(minDiff, time.get(i) - time.get(i-1));
        }
        
        return Math.min(minDiff,(24 * 60 - time.get(n-1) + time.get(0)));
    }
}