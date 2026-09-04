class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seat = booking[2];

            map.put(first, map.getOrDefault(first, 0) + seat);

            map.put(last+1, map.getOrDefault(last+1, 0) - seat);
        }

        int ans[] = new int[n];
        int running = 0;

        for(int flight=1; flight<=n; flight++){
            running += map.getOrDefault(flight, 0);

            ans[flight - 1] = running;
        }

        return ans;
    }
}