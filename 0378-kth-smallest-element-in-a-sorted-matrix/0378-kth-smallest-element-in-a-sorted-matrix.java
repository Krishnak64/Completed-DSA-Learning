class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x[] : matrix){
            for(int i : x) {
                pq.add(i);
            }
        }

        for(int i=0; i<k-1; i++) {
            pq.poll();
        }


        return pq.poll();
    }
}