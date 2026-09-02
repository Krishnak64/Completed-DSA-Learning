class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a); // arranging elements in descending order
        
        for(int x : stones) {
            pq.offer(x);
        }

        while(pq.size() > 1) {
            int x = pq.poll(); // first element
            int y = pq.poll(); // second element

            if(x != y) { // if not equal push diff of element in pq
                pq.offer(x-y);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();  

    }
}