import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static class Matrix {

        int[][] matrix;
        int N;

        public Matrix(int[][] matrix) {
            this.N = matrix.length;
            this.matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    this.matrix[i][j] = matrix[i][j];
                }
            }
        }

        public int[][] makeRotationMatrix() {
            int[][] rotationMatrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rotationMatrix[i][j] = this.matrix[N - 1 - j][i];
                }
            }
            return rotationMatrix;
        }

        public int getElement(int y, int x) {
            return this.matrix[y][x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] originalMatrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    originalMatrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Matrix matrix = new Matrix(originalMatrix);
            Matrix rotationMatrix90 = new Matrix(matrix.makeRotationMatrix());
            Matrix rotationMatrix180 = new Matrix(rotationMatrix90.makeRotationMatrix());
            Matrix rotationMatrix270 = new Matrix(rotationMatrix180.makeRotationMatrix());


            bw.write("#" + tc + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(rotationMatrix90.getElement(i, j) + "");
                }
                bw.write(" ");
                for (int j = 0; j < N; j++) {
                    bw.write(rotationMatrix180.getElement(i, j) + "");
                }
                bw.write(" ");
                for (int j = 0; j < N; j++) {
                    bw.write(rotationMatrix270.getElement(i, j) + "");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
