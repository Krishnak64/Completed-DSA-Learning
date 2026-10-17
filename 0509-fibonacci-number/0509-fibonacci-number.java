class Solution {
    public int fibo(int arr[], int n) {
        if(n == 1 ) {
            return 1;
        }

        if( n == 0) {
            return 0;
        }
        if(arr[n] != -1){
            return arr[n];
        }else {
            return arr[n] = fibo(arr, n-1) + fibo(arr, n-2);
        }
    }
    public int fib(int n) {
        int arr[] = new int[31];
        Arrays.fill(arr, -1);
        return fibo(arr, n);
    }
}