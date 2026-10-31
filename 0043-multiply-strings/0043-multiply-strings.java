class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int n1 = num1.length();
        int n2 = num2.length();
        int res[] = new int[n1 + n2];
        for(int i=n1-1; i>=0; i--) {
            for(int j=n2-1; j>=0; j--) {
                int digit = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int prod = digit * digit2;
                int sum = prod + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
         int i = 0;
         while(i < res.length && res[i] == 0) i++;
         for(; i<res.length; i++) {
            sb.append(res[i]);
         }

         return sb.toString();
    }
}