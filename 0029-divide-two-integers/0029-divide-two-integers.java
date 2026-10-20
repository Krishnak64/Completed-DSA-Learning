class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        long num = Math.abs((long)dividend);
        long dev =Math.abs((long)divisor);
        boolean neg1 = false;
        boolean neg2 = false;

        if(dividend < 0) {
            neg1 = true;
        }

        if(divisor < 0) {
            neg2 = true;
        }

        int count = 0;
        while(num >= dev) {
            num = num - dev;
            count++;
        }

        if(neg1 && neg2) {
            return count;
        }

        if(neg1 || neg2) {
            return (-count);
        }

        return count;
    }
}