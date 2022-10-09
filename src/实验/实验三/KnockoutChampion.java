package 实验.实验三;

/**
 *  淘汰赛冠军问题
 *  假设有 n 个选手进行竞技淘汰赛，最后决出冠军的选手，请设计竞技淘汰比赛的过程，输出结
 * 果，输出时要求有文字说明。请任选一种语言编写程序实现上述算法，并分析其算法复杂度。
 */
public class KnockoutChampion {
    public static void main(String[] args) {
        int str[] = {23, 85, 565, 235, 156, 78, 566, 32, 25, 12, 96};
        int max = champion(str, str.length);
        System.out.println("淘汰赛冠军最大值:" + max);
    }

    public static boolean adjust(int x, int y) {
        if (x > y)
            return true;
        else
            return false;
    }

    public static int champion(int[] str, int m) {
        int i = m;
        while (i > 1) {
            i = i / 2;
            for (int j = 0; j < i; j++) {
                if (adjust(str[j + i], str[j]))
                    str[j] = str[j + 1];
            }
        }
        return str[0];
    }
}
