package 实验.实验八;

/**
 * 蛮力算法解决最大子段和问题
 */
public class MaxSum1 {
    public static int bestI = 0, bestJ = 0;

    public static void main(String[] args) {
        int arr[] = {-2, 11, -4, 13, -5, -2};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int res = maxSum(arr.length, arr);
        System.out.println();
        System.out.println("最大连续子段和为：arr[" + bestI + "..." + bestJ + "]:" + res);
    }

    private static int maxSum(int n, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int thisSum = 0;
            for (int j = i; j < n; j++) {
                thisSum += arr[j];
                if (thisSum > sum) {
                    sum = thisSum;
                    bestI = i;
                    bestJ = j;
                }
            }
        }
        return sum;
    }
}
