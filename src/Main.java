import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long sum1 = 0, sum2 = 0;
        int d[] = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            sum1 += a;
            sum2 += b;
            d[i] = a - b;
        }
        if (sum2 > m) {
            System.out.print(-1);
        } else if (sum1 <= m) {
            System.out.print(0);
        } else {
            Arrays.sort(d);
            for (int i = 1; ; i++) {
                sum1 -= d[n - i];
                if (sum1 <= m) {
                    System.out.print(i);
                    return;
                }
            }
        }
    }
}

