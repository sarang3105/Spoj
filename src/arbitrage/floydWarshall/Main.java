package arbitrage.floydWarshall;

import java.io.*;
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
            double[][] edges = new double[N][N];

            for (int i = 0; i < e; i++) {
                int u = vertexMap.get(sc.next());
                double w = sc.nextDouble();
                int v = vertexMap.get(sc.next());
                edges[u][v] = w;
            }
            if (!isPossible(edges, N)) {
                System.out.println("Case " + idx + ": No");
            } else {
                System.out.println("Case " + idx + ": Yes");
            }
            idx++;
        }
    }

    private static boolean isPossible(double[][] edges, int vertices) {
        floydWarshall(edges, vertices);
        for (int u = 0; u < vertices; u++) {
            if (edges[u][u] > 1.0) {
                return true;
            }
        }
        return false;
    }

    private static void floydWarshall(double[][] edges, int vertices) {
        for (int p = 0; p < vertices; p++) {
            for (int u = 0; u < vertices; u++) {
                for (int v = 0; v < vertices; v++) {
                    edges[u][v] = Math.max(edges[u][v], edges[u][p] * edges[p][v]);
                }
            }
        }
    }
}
