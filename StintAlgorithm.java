public class StintAlgorithm {
    public static void main(String[] args) {
        int k = 3;
        int m = 8;
        int l;
        int r;
        int i;
        int j;
        if (m % k == 0) {
            l = m / k;
        } else {
            l = m / k - 1;
        }

        for (j = 0; j < l; j++) {
            System.out.print("(");
            for (i = k * j + 1; i <= k * (j + 1); i++) {
                if (i != k * (j + 1)) {
                    System.out.print("S" + i + ",");
                } else {
                    System.out.print("S" + i);
                }
            }
            System.out.println(") Tgian : 1 unit");
        }

        r = m - l * k;
        if (r != 0) {
            int n = l * k + 1;
            for (j = n; j <= m - k + 1; j++) {
                System.out.print("(");
                for (i = j; i <= j + k - 1; i++) {
                    if (i != j + k - 1) {
                        System.out.print("S" + i + ",");
                    } else {
                        System.out.print("S" + i);
                    }
                }
                System.out.println(") Tgian : 1/" + k + " unit");
            }

            for (j = m - k + 2; j <= m; j++) {
                System.out.print("(");
                for (i = j; i < j + k - 1; i++) {
                    if (i > m) {
                        System.out.print("S" + (i - m + n - 1) + ",");
                    } else {
                        System.out.print("S" + i + ",");
                    }
                }
                i = j + k - 1;
                if (i > m) {
                    System.out.print("S" + (i - m + n - 1));
                } else {
                    System.out.print("S" + i);
                }
                System.out.println(") Tgian : 1/" + k + " unit");
            }
        }
    }
}
