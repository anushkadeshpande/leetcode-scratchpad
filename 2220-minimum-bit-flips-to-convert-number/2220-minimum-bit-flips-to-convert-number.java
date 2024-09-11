class Solution {
    public int minBitFlips(int start, int goal) {
        // convert start and goal to binary
        // compare the 2 strings bit by bit
//         String startBinary = convertToBinary(start);
//         String goalBinary = convertToBinary(goal);
        
//         int i = startBinary.length() - 1;
//         int j = goalBinary.length() - 1;
        
//         System.out.println(startBinary);
//         System.out.println(goalBinary);
        
//         int count = 0;
//         while(i >= 0 && j >= 0) {
            
            
//             if(startBinary.charAt(i) != goalBinary.charAt(j)) {
//                 // System.out.println(startBinary.charAt(i));
//                 // System.out.println(goalBinary.charAt(j));
//                 count += 1;
                
//                 // System.out.println(count);
//             }
//             i--;
//             j--;
//         }
        
//         // System.out.println(i);
//         // System.out.println(j);
//         if(i >= 0) {
            
//             count += i + 1;
//         } 
//         if(j >= 0) {
//             // 
//             count += j + 1;
            
//         }
//         return count;
        
        
        // TAKE XOR OF 2 NUMBERS
        // COUNT NUMBER OF SET BITS
        int xor = start ^ goal;
        
        int count = 0;
        while(xor > 0) {
            count = count + (xor & 1);
            xor = xor >> 1;
        } 
        
        return count;
    }
    
//     public String convertToBinary(int num) {
//         String binary = "";
//         while(num != 0) {
//             int bit = num % 2;
//             num = num / 2;
//             binary = bit + binary;
//         }
        
//         return binary;
//     }
}