package 实验.实验八;

/**
 * 分治算法解决最大子段和问题
 */
public class MaxSum2 {
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
        return maxSubSum(arr, 0, n - 1);
    }

    private static int maxSubSum(int arr[], int left, int right) {
        int sum = 0;
        if (left == right) {
            sum = arr[left] > 0 ? arr[left] : 0;
        } else {
            int center = (left + right) / 2;
            int leftSum = maxSubSum(arr, left, center);
            int rightSum = maxSubSum(arr, center + 1, right);

            int s1 = 0;
            int lefts = 0;
            for (int i = center; i >= left; i--) {

                lefts += arr[i];
                if (lefts > s1) s1 = lefts;
            }
            int s2 = 0;
            int rights = 0;
            for (int i = center + 1; i < right; i++) {

                rights += arr[i];
                if (rights > s2) s2 = rights;
            }
            sum = s1 + s2;
            if (sum < leftSum) sum = leftSum;
            if (sum < rightSum) sum = rightSum;
        }
        return sum;
    }
}
