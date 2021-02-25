package defendTheRohan;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://www.spoj.com/problems/ROHAAN/
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int m = 1; m <= t; m++) {
            int n = Integer.parseInt(br.readLine());
            long[][] graph = new long[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split("\\s");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int p = 0; p < n; p++) {
                for (int u = 0; u < n; u++) {
                    for (int v = 0; v < n; v++) {
                        graph[u][v] = Math.min(graph[u][v], graph[u][p] + graph[p][v]);
                    }
                }
            }
            int r = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int i = 0; i < r; i++) {
                String[] sd = br.readLine().split("\\s");
                int u = Integer.parseInt(sd[0]) - 1;
                int v = Integer.parseInt(sd[1]) - 1;
                sum += graph[u][v];
            }
            System.out.printf("Case #%d: %d", m, sum);
            System.out.println();
        }
    }
}
