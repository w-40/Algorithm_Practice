package 实验.实验二;
/**
 * 堆排序
 */
import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        //int[] arr = {2,5,9,1,6,3};
        System.out.println("请输入要排序的数的个数");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        //从倒数第一个非叶子节点开始
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子节点从下至上，从左至右调整结构
            adjustHeap(arr, i, arr.length);
        }

        //将堆顶元素与末尾元素交换 将最大元素沉到数组末尾 + 重新调整堆结构
        for (int i = arr.length - 1; i > 0; i--) {
            //交换堆顶元素和末尾元素
            swap(arr, 0, i);
            //交换后的末尾元素忽略(j--) 不再参与堆结构的调整
            //重新调整堆结构
            adjustHeap(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    public static void adjustHeap(int[] arr, int index, int length) {
        //取出当前元素
        int temp = arr[index];
        //i节点是index节点的左子节点
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            //表明左子节点小于右子节点
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                //将指针移至较大节点
                i++;
            }
            //如果子节点大于父节点
            if (arr[i] > temp) {
                //将较大值赋给当前节点
                arr[index] = arr[i];
                //指针移向子节点
                index = i;
            } else {
                break;
            }
        }
        //循环结束，已经将最大值放在了堆顶
        //将temp值放到最终的位置
        arr[index] = temp;
    }
}
