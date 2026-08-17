/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> seen = new HashMap<>();
        return dfs(node, seen);
    }

    public Node dfs(Node node, Map<Integer, Node> seen) {
        if (node == null) return null;
        if (seen.containsKey(node.val)) return seen.get(node.val);

        Node newNode = new Node(node.val);
        seen.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            Node adj = dfs(neighbor, seen);
            newNode.neighbors.add(adj);
        }
        return newNode;

    }
}