class Solution {
    private void dfs(int node, int[][] graph, List<List<Integer>> result, List<Integer> path) {
        path.add(node);  // Add current node to path
        
        // If we reach the last node (n-1), add the path to result
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {
            // Explore all neighbors
            for (int neighbor : graph[node]) {
                dfs(neighbor, graph, result, path);
            }
        }

        path.remove(path.size() - 1);  // Backtrack to explore other paths
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();  // Store all paths
        List<Integer> path = new ArrayList<>();  // Store the current path
        dfs(0, graph, result, path);  // Start DFS from node 0
        return result;
    }
}
