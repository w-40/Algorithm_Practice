package 练习.ACC;

import java.util.Scanner;

public class CountCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String s = Integer.toHexString(input);

        //System.out.println(cur);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //System.out.println(c);
            if (c == '0' || c == '4' || c == '6' || c == '9' || c == 'a' ||c == 'd') {
                res++;
            }else if (c == '8' || c == 'b'){
                res = res + 2;
            }
        }
        System.out.println(res);
    }
}
