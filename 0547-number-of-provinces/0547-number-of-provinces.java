class Solution {
    private void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()){
            Integer node = q.remove();
            for(int neighbor : adj.get(node)){
                if(!vis[neighbor]){
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j); // Add edge from i to j
                    adj.get(j).add(i); // Add edge from j to i (for undirected graph)
                }
            }
        }

        
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;

        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                count++;
                bfs(i, adj, vis);
            }
        }

        return count;
    }
}