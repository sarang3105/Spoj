package InversionCount;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://www.spoj.com/problems/INVCNT/
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(br.readLine());
            }
            System.out.println(sort(ar, 0, n - 1));
        }
    }

    private static long sort(int[] arr, int start, int end) {
        long sum = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            sum += sort(arr, start, mid);
            sum += sort(arr, mid + 1, end);
            sum += merge(arr, start, end, mid + 1);

        }
        return sum;
    }

    private static long merge(int[] arr, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid, k = 0; long count = 0;
        while (i <= mid - 1 && j <= end) {
            if (arr[j] >= arr[i]) {
                temp[k++] = arr[i++];
            } else {
                if(arr[i] > arr[j]) {
                    count += (mid - i);
                }
                temp[k++] = arr[j++];
            }
        }

        int m;
        for (m = i; m <= mid - 1; m++) {
            temp[k++] = arr[m];
        }

        for (m = j; m <= end; m++) {
            temp[k++] = arr[m];
        }

        for (i = start ; i<= end; i++) {
            arr[i] = temp[i - start];
        }
        return count;
    }
}
