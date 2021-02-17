package aggressiveCows;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @linkhttps://www.spoj.com/problems/AGGRCOW/
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nc = br.readLine().split("\\s");
            int n = Integer.parseInt(nc[0]);
            int c = Integer.parseInt(nc[1]);
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            System.out.println(binarySearch(arr, c, n));
        }
    }

    private static int binarySearch(int[] arr, int c, int n) {
        int start = 0, end = arr[n - 1], dist = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(arr, c, mid)) {
                start = mid + 1;
                if (mid > dist) {
                    dist = mid;
                }
            } else {
                end = mid - 1;
            }
        }
        return dist;
    }

    private static boolean check(int[] arr, int c, int dist) {
        int placed = 1, pos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pos >= dist) {
                placed++;
                if (placed == c) return true;
                pos = arr[i];
            }
        }
        return false;
    }
}
