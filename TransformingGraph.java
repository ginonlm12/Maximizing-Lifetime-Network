import java.util.Scanner;
public class TransformingGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        System.out.print("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        int[][] OGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhap vao gia tri OGraph[" + i + "][" + j + "]: ");
                OGraph[i][j] = sc.nextInt();
            }
        }

        int[][] RGraph = new int[2 * n - 2][2 * n - 2];
        for (int i = 0; i < 2 * n - 2; i++) {
            for (int j = 0; j < 2 * n - 2; j++) {
                RGraph[i][j] = 0;
            }
        }
        RGraph[0][0] = OGraph[0][0];
        for (int i = 1; i < n - 1; i++) {
            RGraph[0][2 * i - 1] = OGraph[0][i];
        }
        for (int i = 1; i < n - 1; i++) {
            RGraph[2 * i][2 * n - 3] = OGraph[n - 1][i];
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (i == j) {
                    RGraph[2 * i - 1][2 * i] = 1;
                    RGraph[2 * i][2 * i - 1] = OGraph[i][i];
                } else {
                    if (OGraph[i][j] != 0) {
                        RGraph[2 * i][2 * j - 1] = OGraph[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < 2 * n - 2; i++) {
            for (int j = 0; j < 2 * n - 2; j++) {
                System.out.print(RGraph[i][j] + "  ");
            }
            System.out.println();
        }
        sc.close();
    }
}
