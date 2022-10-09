package 实验.实验三;

public class BSearch {
    public static void main(String[] args) {
        int[] data = {4, 9, 10, 11, 12, 13, 21, 27};
        int a = 10;
        int index = biSearch(data, a);
        System.out.println(a + "在数组中的位置为：" + index);
    }

    public static int biSearch(int[] arr, int a) {
        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;//中间位置
            if (a < arr[mid]) {
                high = mid - 1;
            } else if (a > arr[mid]) {
                low = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return mid;
    }
}
