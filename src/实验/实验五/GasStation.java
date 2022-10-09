package 实验.实验五;

/**
 * 1.要让车加油次数最少，我们要让车每次尽可能的开远一点再加油
 * 2.我们首先需要假设让车开出最远的距离n千米，找出距离最近且靠近出发点的一个加油站进行加油。
 * 3.当加完油之后，车又恢复到满油状态，只需要接着让车按照2的思路，找到接下来如何安排加油站。
 */
public class GasStation {
    public static void main(String[] args) {
        //输入
        int n = 20;//加满油后最远行驶距离
        int num = 9;//加油站数量
        int[] gasStation = {10, 20, 35, 40, 50, 65, 75, 85, 100};//加油站位置
        int s = 100;//路线全长

        int count = 0;//加油次数
        int nowDistance = 0;//当前行驶的距离
        int i = 0;
        int driveDistance = gasStation[0];
        while (nowDistance < s && i <= num - 1) {
            if ((gasStation[i + 1] - gasStation[i]) > (n - driveDistance)) {
                System.out.println("在第" + (i + 1) + "加油站，加了一次油");
                nowDistance = gasStation[i + 1];
                driveDistance = gasStation[i + 1] - gasStation[i];
                i++;
                count++;
            } else {
                nowDistance = gasStation[i + 1];
                driveDistance += gasStation[i + 1] - gasStation[i];
                i++;
            }
        }
        System.out.println("全程一共加了" + count + "次油");
    }
}
