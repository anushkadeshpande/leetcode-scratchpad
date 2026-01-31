class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // binary search
        int n = letters.length;

        int i = 0;
        int j = n-1;

        char greaterElement = letters[0];

        while(i <= j) {
            int mid = (i + j)/2;

            if(letters[mid] <= target)
                i = mid+1;
            else {
                // the mid is greater than target
                greaterElement = letters[mid];
                j = mid-1;
            }

        }

        return greaterElement;
    }
}