class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        if (!dfs(0, -1, adjList, seen)) return false;

        return seen.size() == n;
    }

    private boolean dfs(int i, int from, List<List<Integer>> adjList, Set<Integer> seen) {
        if (seen.contains(i)) return false;
        seen.add(i);
        for(int neighbor : adjList.get(i)) {
            if (neighbor == from) continue;
            if (!dfs(neighbor, i, adjList, seen)) return false;
        }
        return true;
    }
}
