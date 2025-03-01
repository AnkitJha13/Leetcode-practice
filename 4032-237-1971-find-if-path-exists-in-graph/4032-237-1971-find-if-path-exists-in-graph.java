class Solution {
    private boolean dfs(int src, int dest, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        if(src == dest) return true;

        vis[src] = true;

        for(int neighbor : adj.get(src)){
            if(!vis[neighbor] && dfs(neighbor, dest, adj, vis)){
                return true;
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);  // add 1 to 0 and 0 to 1 like this for all
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        return dfs(source, destination, adj, vis);
    }
}