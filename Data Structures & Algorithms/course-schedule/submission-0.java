class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>()); 
        }

        for (int[] prereq : prerequisites) {
            adjList.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!search(i, adjList, seen)) return false;;
        }
        return true;
    }

    private boolean search(int i, List<List<Integer>> adjList, Set<Integer> seen) {
        if (seen.contains(i)) return false;

        seen.add(i);

        for(int neighbor : adjList.get(i)) {
            if (!search(neighbor, adjList, seen)) return false;
            seen.remove(neighbor);
        }

        seen.remove(i);

        return true;
    }
}
