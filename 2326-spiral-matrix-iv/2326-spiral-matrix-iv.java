/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int i=0;
        int j=0;
        int[][] matrix = new int[m][n];
        
        int top = 0;
        int bottom = m-1;
        
        int left = 0;
        int right = n-1;
        
        for(i=0; i<m; i++) {
            for(j =0; j<n; j++)
                matrix[i][j] = -1;
        }
        i=0;
        j=0;

        while(head != null) {
            
            i = left;
            while(head != null && i <= right) {
                matrix[top][i] = head.val;
                head = head.next;
                i++;
            } 
            
            top++;
            i = top;
            
            while(head != null && i <= bottom) {
                matrix[i][right] = head.val;
                head = head.next;
                i++;
            }
            right--;
            i = right;
            
            while(head != null && i >= left) {
                matrix[bottom][i] = head.val;
                head = head.next;
                i--;
            }
            
            bottom--;
            i=bottom;
            
            while(head != null && i >= top) {
                matrix[i][left] = head.val;
                head = head.next;
                i--;
            }
            
            left++;

        }
        
        return matrix;
    }
}