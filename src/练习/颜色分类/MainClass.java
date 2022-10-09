package 练习.颜色分类;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 首先你得合理安排0，1，2.我想到的最好方法是三路开花。就像雇佣三个搬运工一样。
 * 一个负责核查所有物品（数组元素）的身份信息，另外两个负责一前一后搬运核查是0的放前面，
 * 是2的放后面。这个放又有点意思。我可以以交换的方式来搬运，大家都合理使用劳动力，公平。
 * 而且每一次搬运（交换形式），那个负责核查的又再核查一遍手里换来的物品吗？
 * 其实可以这样解决，只要是和前面自己已经检查过的换的话就直接换完继续检查下一个了，
 * 只有和后面自己没有检查的物品才需要继续再查一遍，但这个时候要记住另外两个搬运的不是一直停留在原地的，
 * 每一次交换都要往前走一步的，毕竟前面的都排好了。当然这里我还遇到了一点小问题就是用3个if还是用if else语句。
 * 前者是相当于三条路，走完一条路还要回到原点再继续走另一条直到走完三条路才算完成一个循环，
 * 但是如果i++的话很可能改变nums[i]的数值，所以前面是行不通的。
 *
 */
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            new Solution().sortColors(nums);
            String out = integerArrayToString(nums);

            System.out.print(out);
        }
    }
}