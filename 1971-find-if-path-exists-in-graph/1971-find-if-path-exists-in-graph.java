class Solution {
    public boolean isPathAvailable(ArrayList<ArrayList<Integer>> adj, int src, int dest, boolean vis[]) {
        if(src == dest) {
            return true;
        }

        vis[src] = true;

        for(int i=0; i < adj.get(src).size(); i++) {
            int e = adj.get(src).get(i);
            if(!vis[e] && isPathAvailable(adj, e, dest, vis)) {
                return true;
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        return isPathAvailable(adj, source, destination, vis);
    }
}