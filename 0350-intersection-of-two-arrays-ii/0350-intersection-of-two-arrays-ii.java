class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        
        List<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                intersection.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else 
                i++;
        }
        
        int[] answer = new int[intersection.size()];
        
        for(i =0; i<intersection.size(); i++)
            answer[i] = intersection.get(i);
        
        return answer;
    }
}