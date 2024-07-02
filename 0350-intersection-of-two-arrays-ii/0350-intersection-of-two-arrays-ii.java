class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++) {
            if(map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 1);
        }
        
        
        List<Integer> intersection = new ArrayList<>();
        
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                intersection.add(nums2[i]);
                }
        }
        
        
        int[] answer = new int[intersection.size()];
        
        for(int i =0; i<intersection.size(); i++)
            answer[i] = intersection.get(i);
        
        return answer;
    }
}