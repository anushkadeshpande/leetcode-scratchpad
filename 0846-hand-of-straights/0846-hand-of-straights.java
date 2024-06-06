class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        int n = hand.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.putIfAbsent(hand[i],new ArrayList<>());
            map.get(hand[i]).add(i);
        }
        //System.out.println(map);
        for(int i = 0;i < n;i++){
            if(hand[i] == -1) continue;
            int next = hand[i];
            
            for(int j = 0;j < groupSize;j++){
                //System.out.println(next);
                if(map.containsKey(next)){
                    hand[map.get(next).remove(0)] = -1;
                    if(map.get(next).size() == 0){
                        map.remove(next);
                    }
                    next++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}