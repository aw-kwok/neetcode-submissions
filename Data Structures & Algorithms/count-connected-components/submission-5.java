class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int count = n;
        for(int[] edge : edges) {
            if (union(edge[0], edge[1], parent, rank)) count--;
        }
        return count;
    }
    
    private int find(int n, int[] parent) {
        int curr = n;
        while (curr != parent[curr]) {
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }
        return curr;
    }

    private boolean union(int i, int j, int[] parent, int[] rank) {
        int parentI = find(i, parent);
        int parentJ = find(j, parent);

        if (parentI == parentJ) return false;

        if (rank[parentJ] > rank[parentI]) {
            parent[parentI] = parent[parentJ];
            rank[parentJ] += rank[parentI];
        }
        else {
            parent[parentJ] = parentI;
            rank[parentI] += rank[parentJ];
        }
        return true;
    }
}
