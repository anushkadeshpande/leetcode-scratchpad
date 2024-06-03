class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        
        Set<Integer> intersection = new HashSet<>();
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
        i = 0;
        for(Integer num: intersection) 
            answer[i++] = num;
        
        return answer;
    }
}