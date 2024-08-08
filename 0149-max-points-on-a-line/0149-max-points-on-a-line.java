class Solution {
    public int maxPoints(int[][] points) {
        // slope = y2-y1 / x2-x1
        // find slope between all pairs
        // maintain the count in hashmap
        // return the max occurred slope
        
        
        int n = points.length;
        if(n == 1)
            return 1;
        
        double slope = 0;
        int slopeCnt = 1;
        int res = 1;
        for(int i=0; i<n; i++) {
            Map<Double, Integer> slopes = new HashMap<>();
            for(int j=i+1; j<n; j++) {
                slopeCnt = 0;
                
                // if the x coordinates of both points is same, slope should be inf, lets keep it Integer.MAX_VALUE
                if(points[i][0] == points[j][0])
                    slope = Double.MAX_VALUE;
                else
                    slope = (double)(points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                
                if(slope == -0.0) slope = 0.0;
                slopes.put(slope,slopes.getOrDefault(slope,1)+1);
                // if(slopes.containsKey(slope))
                    // slopeCnt = slopes.get(slope);
                // slopes.put(slope, slopeCnt + 1);
                
                res = Math.max(res, slopes.get(slope));
            }    
        }
        
        return res;
    }
}