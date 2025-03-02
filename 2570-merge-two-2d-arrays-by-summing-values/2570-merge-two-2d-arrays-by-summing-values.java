class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // int[][] res = new int[m+n][2];
        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n) {
            List<Integer> subList = new ArrayList<>();
            if(nums1[i][0] < nums2[j][0]) {
                // res[k][0] = nums1[i][0];
                subList.add(nums1[i][0]);
                // res[k][1] = nums1[i][1];
                subList.add(nums1[i][1]);
                // res.add(Arrays.asList(nums1[i][0], nums1[i][1]));
                i++;
            } else if(nums2[j][0] < nums1[i][0]) {
                // res[k][0] = nums2[j][0];
                subList.add(nums2[j][0]);
                // res[k][1] = nums2[j][1];
                subList.add(nums2[j][1]);
                // res.add(Arrays.asList(nums1[j][0], nums2[j][1]));

                j++;
            } else {
                // res[k][0] = nums2[j][0];
                subList.add(nums1[i][0]);
                // res[k][1] = nums1[i][1] + nums2[j][1];
                subList.add(nums1[i][1] + nums2[j][1]);
                i++;
                j++;
            }
            
            // k++;
                res.add(subList);

        }

        while(i < m) {
            List<Integer> subList = new ArrayList<>();

                // res[k][0] = nums1[i][0];
                subList.add(nums1[i][0]);
                // res[k][1] = nums1[i][1];
                subList.add(nums1[i][1]);
                i++;
                // k++;

                res.add(subList);
        }

        while(j < n) {
                        List<Integer> subList = new ArrayList<>();

                // res[k][0] = nums2[j][0];
                subList.add(nums2[j][0]);

                // res[k][1] = nums2[j][1];
                subList.add(nums2[j][1]);

                j++;
                                res.add(subList);

                // k++;
        }
        int[][] resArr = new int[res.size()][2];

            // System.out.println(res.size());


        for(int idx=0; idx<res.size(); idx++) {
            resArr[idx][0] = res.get(idx).get(0);
            resArr[idx][1] = res.get(idx).get(1);
            // System.out.println(res.get(idx).get(0) + ":" + res.get(idx).get(1));
        }
        return resArr;
    }
}