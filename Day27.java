import java.util.*;

class ShortestPath {
    public int findShortestPath(int V, int[][] edges, int start, int end) {
        if (start == end) {
         
            return 0;
        }

        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); 
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int distance = current[1];

            if (currentNode == end) {
                return distance;
            }

            if (adjList.containsKey(currentNode)) {
                for (int neighbor : adjList.get(currentNode)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(new int[]{neighbor, distance + 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPath solver = new ShortestPath();

        int V1 = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        int start1 = 0;
        int end1 = 4;
        System.out.println("Test Case 1:");
        System.out.println("Input: V=" + V1 + ", Edges=" + Arrays.deepToString(edges1) + ", start=" + start1 + ", end=" + end1);
        int result1 = solver.findShortestPath(V1, edges1, start1, end1);
        System.out.println("Output: " + result1);
        System.out.println("Expected Output: 3");
        System.out.println("--------------------");

        int V2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}};
        int start2 = 0;
        int end2 = 2;
        System.out.println("Test Case 2:");
        System.out.println("Input: V=" + V2 + ", Edges=" + Arrays.deepToString(edges2) + ", start=" + start2 + ", end=" + end2);
        int result2 = solver.findShortestPath(V2, edges2, start2, end2);
        System.out.println("Output: " + result2);
        System.out.println("Expected Output: 2");
        System.out.println("--------------------");

        int V3 = 4;
        int[][] edges3 = {{0, 1}, {1, 2}};
        int start3 = 2;
        int end3 = 3;
        System.out.println("Test Case 3:");
        System.out.println("Input: V=" + V3 + ", Edges=" + Arrays.deepToString(edges3) + ", start=" + start3 + ", end=" + end3);
        int result3 = solver.findShortestPath(V3, edges3, start3, end3);
        System.out.println("Output: " + result3);
        System.out.println("Expected Output: -1");
        System.out.println("--------------------");
    }
}
