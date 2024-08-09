class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                int n = nums1.length;
        int m = nums2.length;
        
        int medianIdx = 0;
        int medianIdx2 = 0;
        
        if(n + m == 1) {
            return nums1.length > 0 ? nums1[0] : nums2[0];
        }
        
        medianIdx = ((n + m) / 2) - 1;
        // System.out.println(medianIdx);

        medianIdx2 = medianIdx + 1;
        
        int i = 0;
        int j = 0;
        double currElement = 0;
        double prevElement = 0;
        int counter = 0;
        
        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                prevElement = currElement;
                currElement = nums1[i];
                
                i++;
            } else {
                
                prevElement = currElement;
                currElement = nums2[j];
                
                j++;
            }
            counter++;
            
            if(((n+m) % 2 == 0 && counter-1 == medianIdx2) || ((n+m) % 2 != 0 && counter-1 == medianIdx2))
                break;
            
        }
        
        
        if(((n+m) % 2 == 0 && counter-1 != medianIdx2) || ((n+m) % 2 != 0 && counter-1 != medianIdx2)) {
                while(i < n) {
                        prevElement = currElement;
                        currElement = nums1[i];
                  
                        i++;
                    
                    counter++;

                    if(((n+m) % 2 == 0 && counter-1 == medianIdx2) || ((n+m) % 2 != 0 && counter-1 == medianIdx2))
                        break;  
                }
            
            while(j < m) {
                        prevElement = currElement;
                        currElement = nums2[j];
                  
                        j++;
                    counter++;

                    if(((n+m) % 2 == 0 && counter-1 == medianIdx2) || ((n+m) % 2 != 0 && counter-1 == medianIdx2))
                        break;  
                }
            }
            if((n+m) % 2 == 0)
                return (double)(currElement + prevElement) / 2.0;
            else
                return currElement;

    }
}