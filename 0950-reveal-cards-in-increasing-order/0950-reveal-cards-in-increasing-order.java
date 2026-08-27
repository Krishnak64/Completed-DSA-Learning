class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        Deque<Integer> q = new ArrayDeque<>();
        q.addFirst(deck[len-1]);

        for(int i=len-2; i>=0 ;i--) {
            int ele = q.removeLast();
            q.addFirst(ele);
            q.addFirst(deck[i]);
        }
        int ans[] = new int[len];

        for(int i=0; i<len; i++) {
            ans[i] = q.removeFirst();
        }

        return ans;
    }
}