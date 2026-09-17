class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.offer(num);
        }

        while(k > 0) {
            pq.offer(-pq.poll());
            k--;
        }

        int sum = 0;

        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}