class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr2) {
           map.put(i, 0);
        }
        Arrays.sort(arr1);
        
        // add count if every element to hashmap
        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        int r = 0;
        int[] result = new int[arr1.length];
        for (int i : map.keySet()) {
            int c = map.get(i);
            for (int j = 0; j < c; j++) {
                result[r++] = i;
            }
        }
        return result;
    }
}