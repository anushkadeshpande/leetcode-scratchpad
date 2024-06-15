class Solution {
    class Project implements Comparable<Project>{
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        public int compareTo(Project p) {
            return this.capital - p.capital;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // for every project, we either choose it or not
        // profit should be maximum
        // capital should be <= w
        // only k projects can be selected
        
        // use 2 heaps - minHeap to track minimum capital
        // maxHeap - to track the max profit
        
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<Project>();
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        for(int i=0; i<profits.length; i++) {
            minCapitalHeap.offer(new Project(profits[i], capital[i]));
        }
        
        for(int i=0; i<k; i++) {
            
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w) {
                // add to max profit heap and remove from min profit heap
                int p = minCapitalHeap.poll().profit;
                maxProfitHeap.offer(p);
            }
            
            if(maxProfitHeap.isEmpty())
                return w;
            
            w += maxProfitHeap.poll();
        }
        
        return w;
    }
}