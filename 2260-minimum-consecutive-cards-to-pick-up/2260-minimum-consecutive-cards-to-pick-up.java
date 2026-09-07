class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = cards.length;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            if(map.containsKey(cards[i])) {
                int len = i - map.get(cards[i]) + 1;
                ans = Math.min(len, ans);
            }
            map.put(cards[i], i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}