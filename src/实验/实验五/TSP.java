package 实验.实验五;

/**
 * 给出 n 个城市及任意两城市间的距离，要求旅行家在旅行者 n 个城市时，各个城市经历且仅经
 * 历一次然后回到出发城市，使得所走的路径最短。输出结果，输出时要求有文字说明。请任选一种
 * 语言编写程序实现上述算法，并分析其算法复杂度。
 */
public class TSP {
    private int cityNum = 4;
    private int[][] distance = { //每个城市的距离矩阵
            {999, 2, 6, 5},
            {2, 999, 5, 4},
            {6, 5, 999, 2},
            {5, 4, 2, 999}
    };
    private boolean[] col = new boolean[4];//标记数组，用于标记列是否被访问
    private boolean[] row = new boolean[4];//标记数组，用于标记行是否被访问

    private void getTsp() {
        for (int i = 0; i < cityNum; i++) {//初始化标记数组
            col[i] = false;
            row[i] = false;//默认都没有被访问
        }
        col[0] = true;//从标号为0的节点开始
        int current = 0;//当前节点 (在矩阵中也表示当前行)
        int next = 0;//下一个节点
        int[] temp = new int[cityNum];//用于存储当前节点到其他节点的距离
        String path = "0";//用于保存路径
        int sum = 0;
        int count = 0;//用于计数
        while (row[current] == false) {//终点是回到第一个节点，已经被标记已经访问过
            count++;
            if (count >= cityNum) {
                path += "-->0";
                sum += temp[0];
                System.out.println("path:" + path);
                System.out.println("sum:" + sum);

            }
            for (int j = 0; j < cityNum; j++)
                temp[j] = distance[current][j];
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < cityNum; k++) {//寻找当前节点相连的最小的节点
                if (temp[k] < min && col[k] == false) {
                    min = temp[k];
                    index = k;
                }
            }
            sum += min;
            path = path + "-->" + index;
            row[current] = true;
            col[next] = true;
            next = index;
            current = next;
        }
    }

    public static void main(String[] args) {
        new TSP().getTsp();
    }
}
