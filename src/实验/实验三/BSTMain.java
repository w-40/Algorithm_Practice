package 实验.实验三;

public class BSTMain {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(1,5);
        bst.put(2,3);
        bst.put(3,83);
        bst.put(4,53);
        bst.put(5,13);
        Object o = bst.get(3);
        System.out.println("要查找的key对应的value为：" + o);
    }
}
