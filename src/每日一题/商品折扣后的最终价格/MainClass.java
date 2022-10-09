package 每日一题.商品折扣后的最终价格;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        //[8,4,6,2,3]
        //[4, 2, 4, 2, 3]
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && prices[deque.peekLast()] >= prices[i]) {
                int idx = deque.pollLast();
                ans[idx] = prices[idx] - prices[i];
            }
            deque.addLast(i);
            ans[i] = prices[i];
        }
        return ans;
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
        for (int index = 0; index < parts.length; index++) {
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
        for (int index = 0; index < length; index++) {
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
            int[] prices = stringToIntegerArray(line);

            int[] ret = new Solution().finalPrices(prices);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
