package 实验.实验七;

/**
 * 有 n 个物品，它们有各自的重量和价值。现有给定容量的背包，如何让背包里装入
 * 的物品具有最大的价值？
 */
public class ZeroToOnePackage {
    public static void main(String[] args) {
        int[] weight = new int[]{2, 2, 6, 5, 4};
        int[] value = new int[]{6, 3, 5, 4, 6};
        int cap = 10;//背包容量：weight：10
        System.out.println("结果为："+zeroToOnePackage(weight, value, cap));
    }

    private static int zeroToOnePackage(int[] weight, int[] value, int cap) {
        if (cap == 0 || weight.length == 0) {
            return 0;
        }
        int len = weight.length;
        int[][] f = new int[len][cap + 1];//cap+1因为给定容量为cap，因此j的循环必须到cap
        for (int j = 1; j < cap + 1; j++) {
            for (int i = 0; i < len; i++) {
                if (weight[i] > j) {//如果当前物品重量大于整个背包的承重
                    if (i == 0) {//如果当前只考虑了第一个物品
                        f[i][j] = 0;
                    } else {
                        f[i][j] = f[i - 1][j];
                    }
                } else {
                    if (i == 0) {//如果当前只考虑了第一个物品
                        f[i][j] = value[i];
                    } else {
                        f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - weight[i]] + value[i]);
                    }
                }
            }
        }
        return f[len - 1][cap];
    }
}
