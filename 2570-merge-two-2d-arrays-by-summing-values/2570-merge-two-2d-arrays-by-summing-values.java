class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < m && j < n) {
            if(nums1[i][0] < nums2[j][0]) {
                res.add(Arrays.asList(nums1[i][0], nums1[i][1]));
                i++;
            } else if(nums2[j][0] < nums1[i][0]) {
                res.add(Arrays.asList(nums2[j][0], nums2[j][1]));
                j++;
            } else {
                res.add(Arrays.asList(nums1[i][0], nums1[i][1] + nums2[j][1]));

                i++;
                j++;
            }
        }

        while(i < m) {
                res.add(Arrays.asList(nums1[i][0], nums1[i][1]));

                i++;
        }

        while(j < n) {
            res.add(Arrays.asList(nums2[j][0], nums2[j][1]));

                j++;
        }
        int[][] resArr = new int[res.size()][2];


        for(int idx=0; idx<res.size(); idx++) {
            resArr[idx][0] = res.get(idx).get(0);
            resArr[idx][1] = res.get(idx).get(1);
        }
        return resArr;
    }
}