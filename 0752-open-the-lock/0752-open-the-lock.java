class Solution {
    public int openLock(String[] deadends, String target) {
        
        // new set to store deadends (to minimize the lookup time)
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                String lockPosition = queue.poll();
                
                if(deadEnds.contains(lockPosition)) {
                    size--;
                    continue;
                }
                
                if(lockPosition.equals(target)) {
                    return level;
                }
                
                StringBuilder sb = new StringBuilder(lockPosition);
                for(int i=0; i<4; i++) {
                    char currentPosition = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (currentPosition == '9'? 0 : currentPosition - '0' + 1) + sb.substring(i+1);
                    String s2 = sb.substring(0, i) + (currentPosition == '0'? 9 : currentPosition - '0' - 1) + sb.substring(i+1);
                    
                    if(!visited.contains(s1) && !deadEnds.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    
                    if(!visited.contains(s2) && !deadEnds.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
                
                size--;
            }
            
            level++;
        }
        
        return -1;
    }
}