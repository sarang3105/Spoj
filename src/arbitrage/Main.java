package arbitrage;

import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://www.spoj.com/problems/ARBITRAG/
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;
            Map<String, Integer> vertexMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                vertexMap.put(sc.next(), i);
            }
            int e = sc.nextInt();
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                Edge edge = new Edge();
                edge.src = vertexMap.get(sc.next());
                edge.w = sc.nextDouble();
                edge.dest = vertexMap.get(sc.next());
                edges.add(edge);
            }
            if (cycle(edges, N)) {
                System.out.println("Case "+idx+": No");
            } else {
                System.out.println("Case "+idx+": Yes");
            }
            idx++;
        }
    }

    private static boolean cycle(List<Edge> edges, int vertices) {
        double[] dist = bellmanFord(edges, vertices);
        for (Edge e: edges)
            if (dist[e.src] * e.w > dist[e.dest])
                return false;
        return true;
    }

    private static double[] bellmanFord(List<Edge> edges, int vertices) {
        double[] dist = new double[vertices];
        dist[0] = 1;
        for (int i = 1; i < vertices; i++) {
            for (Edge e : edges) {
                int u = e.src;
                int v = e.dest;
                if (dist[v] < dist[u] * e.w) {
                    dist[v] = dist[u] * e.w;
                }
            }
        }
        return dist;
    }

    static class Edge {
        int src, dest;
        double w;
    }

}
