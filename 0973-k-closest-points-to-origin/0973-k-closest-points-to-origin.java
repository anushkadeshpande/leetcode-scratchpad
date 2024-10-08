class Solution {
    class Pair {
        int[] point = new int[2];
        // int distance;
        
        public Pair(int[] point) {
            this.point = point;
        }
    }
    
    public double getEucledianDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }
    
    public int[][] kClosest(int[][] points, int k) {
        // for every point, put the point and the eucledian distance in a minHeap
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Double.compare(getEucledianDistance(b.point[0], b.point[1], 0, 0), getEucledianDistance(a.point[0], a.point[1], 0, 0)));
        
        for(int i=0; i<points.length; i++) {
            minHeap.add(new Pair(points[i]));
            
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        int[][] result = new int[k][2];
        int j = 0;
        while(!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            
            result[j++] = pair.point;
        }
        
        return result;
    }
}