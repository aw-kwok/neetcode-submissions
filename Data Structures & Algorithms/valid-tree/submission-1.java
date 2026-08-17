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
        for(int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            if (!dfs(i, -1, adjList, seen, visited)) return false;
            for(int j : visited) System.out.print(j + " ");
            if (visited.size() != n) return false;
            System.out.println();
        }
        return true;
    }

    private boolean dfs(int i, int from, List<List<Integer>> adjList, Set<Integer> seen, Set<Integer> visited) {
        if (seen.contains(i)) return false;
        visited.add(i);
        seen.add(i);
        for(int neighbor : adjList.get(i)) {
            if (neighbor == from) continue;
            if (!dfs(neighbor, i, adjList, seen, visited)) return false;
        }
        seen.remove(i);
        return true;
    }
}
