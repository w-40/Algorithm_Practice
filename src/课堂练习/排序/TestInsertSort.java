package 课堂练习.排序;

import java.util.Arrays;

/**
 * 插入排序
 * @author 王志凯
 * @time 2022/03/18
 * */
public class TestInsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 7, 19, 11, 16, 15};
        System.out.println("排序前：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]){
                //将把 arr[index] 向后移动
                arr[index + 1] = arr[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
    }
}
