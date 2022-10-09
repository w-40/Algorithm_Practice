package 实验.成绩管理;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        List<Student> grades = new ArrayList<Student>();
        System.out.println("请输入五个学生：");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            Student stu = new Student(sc.next(), sc.nextInt());
            grades.add(stu);
        }
        Collections.sort(grades);
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getGrade() >= 0 && grades.get(i).getGrade() < 60) {
                count++;
            }
            sum += grades.get(i).getGrade();
        }
        System.out.println("不及格人数为：" + count);
        System.out.println("平均分为" + sum / grades.size());
        for (Student grade : grades) {
            System.out.println(grade);
        }
    }
}




