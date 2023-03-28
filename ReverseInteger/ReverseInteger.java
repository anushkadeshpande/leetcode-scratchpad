package ReverseInteger;

class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;

        while(x != 0) {
            int lastDigit = x % 10;

            if(ans > Integer.MAX_VALUE/10 || ans < Integer.MIN_VALUE/10)
                return 0;
            ans = (ans * 10) + lastDigit;

            x = x /10;
        }

        return ans;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));
    }
}