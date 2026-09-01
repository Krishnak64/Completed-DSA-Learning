class Solution {
    public  class Point implements Comparable<Point>{
        int x; // x axis point
        int y; // y axis point
        int distSqr; // distance from origin
        int idx;

        public Point(int x, int y, int distSqr, int idx){
            this.x = x;
            this.y = y;
            this.distSqr = distSqr;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){ // comparing on the basis of distSqr
            return this.distSqr - p2.distSqr; // sorting in ascending order
        }
    }
    public int[][] kClosest(int[][] pts, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distSqr = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1]; // x*x + y*y
            pq.add(new Point(pts[i][0], pts[i][1],distSqr,i));
        }

        int[][] ans = new int[k][2];

        for(int i=0; i<k; i++) {
            Point p = pq.remove();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
}