package syntax;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    int nodeCount;
    ArrayList<ArrayList<Integer>> adj; // adjacencyList

    Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        this.adj = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    void addEdge(int x, int y) {
        this.adj.get(x).add(y);
    }

    void bfs(int root) {
        boolean[] visited = new boolean[nodeCount];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() != 0) {
            int parent = queue.remove();
            if (visited[parent]) {
                continue;
            }
            visited[parent] = true;
            System.out.print(parent);

            for (int neighbour : adj.get(parent)) {
                queue.add(neighbour);
            }
        }
        System.out.println();
    }

    void dfs(int root) {
        boolean[] visited = new boolean[nodeCount];
        Stack<Integer> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            int parent = stack.pop();
            if (visited[parent]) {
                continue;
            }
            visited[parent] = true;
            System.out.print(parent);

            for (int neighbour : adj.get(parent)) {
                stack.add(neighbour);
            }
        }
        System.out.println();
    }
}

public class GraphExamples {
    public static void main(String[] args) {
        Graph G = new Graph(7);

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2); // redundent

        G.addEdge(1, 3);
        G.addEdge(1, 4);

        G.addEdge(2, 5);
        G.addEdge(2, 6);

        G.bfs(0);
        G.dfs(0);
    }
}
