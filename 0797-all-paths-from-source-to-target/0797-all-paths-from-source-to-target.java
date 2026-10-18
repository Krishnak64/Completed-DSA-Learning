class Solution {
    public void printPath(int node, int[][] graph, List<List<Integer>> res, List<Integer> path) {
        path.add(node);
        if(node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int nextNode : graph[node]) {
            
            printPath(nextNode, graph, res, path);
            path.remove(path.size() - 1);
        }

        

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        printPath(0, graph, res, path);
        return res;
    }
}