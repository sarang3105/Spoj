package toAndFro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Sarangdeep Singh <sarangdeep.singh@outlook.com>
 * @link https://www.spoj.com/problems/TOANDFRO/
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int col = Integer.parseInt(br.readLine());
            if (col == 0) break;
            String line = br.readLine();
            int row = (int) Math.ceil(line.length() / col);
            char[][] code = new char[row][col];
            int j = -1;
            for (int i = 0; i < line.length(); i++) {
                int mod = i % col;
                if (mod == 0) j++;
                if (j % 2 == 0) {
                    code[j][mod] = line.charAt(i);
                } else {
                    code[j][(col - 1) - mod] = line.charAt(i);
                }
            }

            for (int i = 0; i < col; i++) {
                for (int k = 0; k < row; k++) {
                    System.out.print(code[k][i]);
                }
            }
            System.out.println();
        }
    }
}
