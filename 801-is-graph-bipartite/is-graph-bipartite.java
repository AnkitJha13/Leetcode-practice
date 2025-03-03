class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // Mark all as unvisited

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // If unvisited, start BFS
                q.add(i);
                color[i] = 0; // Start with color 0

                while (!q.isEmpty()) {
                    int node = q.remove();

                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) { // Unvisited, assign opposite color
                            color[neighbor] = 1 - color[node];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false; // Same color found, not bipartite
                        }
                        else if(color[neighbor] != color[node]){
                            continue;
                        }
                    }
                }
            }
        }
        return true; // No conflicts found
    }
}