package 实验.实验三;
/**
 *  数字旋转方阵程序设计
 *      给出一个初始数据，在此数据的基础上由外层向里层填写数据，完成一个数字旋转方阵，输出
 *      结果，输出时要求有文字说明。请任选一种语言编写程序实现上述算法，并分析其算法复杂度。
 */

import java.util.Scanner;

public class SquareMatrix {
    public static int[][] data = new int[100][100];
    public static int key = 0;

    public static void main(String[] args) {
        int num, size;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入当前层左上角要填的数字：");

        num = sc.nextInt();
        System.out.println("请输入方阵的阶数：");
        size = sc.nextInt();
        squareMatrix(num, size);
        System.out.println("以下是输出的" + size + "阶数字旋转矩阵：");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void squareMatrix(int num, int size) {
        int i, j, k;
        if (size == 0) {
            return;
        }
        if (size == 1) {
            data[key][key] = num;
            return;
        }
        i = key;
        j = key;
        for (k = 0; k < size - 1; k++) {
            data[i][j] = num;
            num++;
            i++;
        }
        for (k = 0; k < size - 1; k++) {
            data[i][j] = num;
            num++;
            j++;
        }
        for (k = 0; k < size - 1; k++) {
            data[i][j] = num;
            num++;
            i--;
        }
        for (k = 0; k < size - 1; k++) {
            data[i][j] = num;
            num++;
            j--;
        }
        key++;
        squareMatrix(num, size - 2);
    }
}
