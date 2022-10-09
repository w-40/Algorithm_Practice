package 实验.实验八;
/**
 * 动态规划算法解决最大子段和问题
 */
public class MaxSum3 {
    public static void main(String[] args) {
        int arr[] = {-2, 11, -4, 13, -5, -2};
        //          left             right
        for (int i = 0; i < 6; i++) {
            System.out.print(arr[i] + " ");
        }
        int res = maxSum(6, arr);
        System.out.println();
        System.out.println("最大连续子段和为：" + res);
    }

    private static int maxSum(int n, int[] arr) {
        int sum = 0;
        int b = 0;
        for(int i = 0; i < n; i++){
            if(b > 0)
                b += arr[i];
		else
            b = arr[i];
            if(b > sum)
                sum = b;
        }
        return sum;
    }
}
