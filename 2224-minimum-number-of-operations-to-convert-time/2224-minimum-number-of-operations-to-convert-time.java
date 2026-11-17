class Solution {
    public int convertTime(String current, String correct) {
        int h1 = Integer.parseInt(current.substring(0, 2));
        int m1 = Integer.parseInt(current.substring(3, 5));

        int h2 = Integer.parseInt(correct.substring(0, 2));
        int m2 = Integer.parseInt(correct.substring(3, 5));

        int start = h1 * 60 + m1;
        int end = h2 * 60 + m2;

        int count = 0;

        while(start + 60 <= end) {
            count++;
            start += 60;
        }

        while(start + 15 <= end) {
            count++;
            start += 15;
        }

        while(start + 5 <= end) {
            count++;
            start += 5;
        }

        while(start + 1 <= end) {
            count++;
            start += 1;
        }

        return count;
    }
}