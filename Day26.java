import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

    
    private static class Graph {
        private final int V;
        private final List<List<Integer>> adj;

       
        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>(V);
            for (int i = 0; i < V; ++i) {
                adj.add(new ArrayList<>());
            }
        }

       
        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

   
    private static class Pair {
        int vertex;
        int parent;

        public Pair(int vertex, int parent) {
            this.vertex = vertex;
            this.parent = parent;
        }
    }

 
    public boolean detectCycle(int V, int[][] edges) {
        Graph graph = new Graph(V);
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        // visited array to keep track of visited vertices
        boolean[] visited = new boolean[V];

        // Iterate through all vertices to handle disconnected components
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                if (bfs(i, graph.adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean bfs(int startVertex, List<List<Integer>> adj, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startVertex, -1));
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int vertex = current.vertex;
            int parent = current.parent;

            for (int neighbor : adj.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new Pair(neighbor, vertex));
                } else if (neighbor != parent) {
                   
                    return true;
                }
            }
        }
        return false;
    }

 
    public static void main(String[] args) {
        DetectCycleInUndirectedGraph detector = new DetectCycleInUndirectedGraph();

        int V1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        System.out.println("Test Case 1: V = 5, Edges = [[0, 1], [1, 2], [2, 3], [3, 4], [4, 0]]");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + detector.detectCycle(V1, edges1));
        System.out.println("-----------------------------------");

        int V2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}};
        System.out.println("Test Case 2: V = 3, Edges = [[0, 1], [1, 2]]");
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + detector.detectCycle(V2, edges2));
        System.out.println("-----------------------------------");

        int V3 = 4;
        int[][] edges3 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Test Case 3: V = 4, Edges = [[0, 1], [1, 2], [2, 0]]");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + detector.detectCycle(V3, edges3));
        System.out.println("-----------------------------------");

        int V4 = 5;
        int[][] edges4 = {};
        System.out.println("Edge Case 1: No edges");
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + detector.detectCycle(V4, edges4));
        System.out.println("-----------------------------------");

        int V5 = 5;
        int[][] edges5 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
        System.out.println("Edge Case 2: Tree structure");
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + detector.detectCycle(V5, edges5));
        System.out.println("-----------------------------------");

        int V6 = 3;
        int[][] edges6 = {{0, 1}, {1, 2}, {0, 1}};
        System.out.println("Edge Case 3: Parallel edges");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + detector.detectCycle(V6, edges6));
        System.out.println("-----------------------------------");
    }
}
