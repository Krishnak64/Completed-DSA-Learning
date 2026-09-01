class Node implements Comparable<Node>
{
    int row, col, effort;

    Node(int row,int col, int effort)  {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }

    public int compareTo(Node other) {
        return this.effort - other.effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] vis = new boolean[rows][cols];

        //Top, Right, Down, Left
        int [] dr = {-1, 0, +1, 0};
        int [] dc = {0, 1, 0, -1};

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0)); // initiale value

        while(q.size()!=0) {
            Node node = q.remove();
            int sr = node.row, sc = node.col;
            vis[sr][sc] = true;
            int effort = node.effort;
            
            if(sr == rows - 1 && sc == cols - 1) return effort;

            for(int i=0;i < 4;i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if(nr < 0 || nc <0 ||nr >= rows || nc >=cols) continue; // out of matrix
                if(vis[nr][nc]==true) continue; // already visited

                int diff = Math.abs(heights[nr][nc] - heights[sr][sc]);
                q.add(new Node(nr, nc, Math.max(effort, diff)));
            }
        }
        return 0;
    }
}