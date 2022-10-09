package 实验.实验三;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root; //根节点
    private int N;

    private class Node { //结点内部类
        private Key key;
        private Value value;
        private Node left; //当前结点的左结点
        private Node right; //当前结点的右结点

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void put(Key key, Value value) { //向整个树中插入一个键值对
        root = put(root, key, value);// 调用重载的put，从root开始，把根节点传入参数x（指定的某树x）
        //再将新的树更新为根节点root
    }

    private Node put(Node x, Key key, Value value) { //在指定树x中添加一个键值对
        //如果x为空，x直接作为根节点
        if (x == null) {
            N++;
            return new Node(key, value, null, null);  //返回根节点。递归出口！
        }

        //如果x不为空
        int com = key.compareTo(x.key); //先比较
        if (com > 0) {//如果key大于x结点的键，就继续找x结点的右子树
            x.right = put(x.right, key, value);
            //递归调用，把x的右子树作为当前结点再进行比较并put，如果右子树为null，则key作为x的右子树
            //在添加了新的子结点后，树结构发生了变化！ 要将当前结点进行更新。而get方法没有改变树结构，就不需要更新。
        } else if (com < 0) {//如果key小于x结点的键，就继续找x结点的左子树
            x.left = put(x.left, key, value);
            //递归调用，把x的左子树作为当前结点再进行比较并put，如果左子树为null，则key作为x的右子树

        } else {//如果key等于x结点的键，就覆盖x结点的值
            x.value = value;
        }
        return x;  //返回更改过的x
    }

    public Value get(Key key) {  //根据key找出value，需要从整个树查找，所以入口是root
        return get(root, key); //调用重载的get方法，从根节点root开始找

    }

    private Value get(Node x, Key key) { //从指定的树x中，根据key找出value
        if (x == null) {//如果x为null
            return null; //递归到最后没有key相同结点，直接返回null，递归出口1
        } else { //如果x不为null时

            int com = key.compareTo(x.key); //先比较
            if (com > 0) {//如果key大于x结点的键，就继续找x结点的右子树
                return get(x.right, key);
                //递归调用，把x的右子树作为当前结点再进行比较并get，如果右子树为null，则返回null；或者找到key相同的就返回value

            } else if (com < 0) {//如果key小于x结点的键，就继续找x结点的左子树
                return get(x.left, key);
                //递归调用，把x的左子树作为当前结点再进行比较并put，如果左子树为null，则返回null;或者找到key相同的就返回value

            } else {//如果key等于x结点的键，就返回value， 递归出口2
                return x.value;
            }
        }
    }

    public void delete(Key key) {// 删除结点 ※
        delete(root, key);    //需要从整个树查找，所以从root开始
    }

    private Node delete(Node x, Key key) {// 删除指定树x上的键值对，并返回该树
        // 树x为null，即找不到该结点,直接返回null
        if (x == null) {
            return null;
            //即最后没有找到该结点，返回null，即树并没有任何变化！

        } else {
            N--;
            int com = key.compareTo(x.key); //先比较
            if (com > 0) {//如果key大于x结点的键，就继续找x结点的右子树
                x.right = delete(x.right, key);
                //递归调用，把x的右子树作为当前结点再进行比较，如果右子树为null，则返回null；或者找到key相同的进入删除部分的逻辑，
                //最后若删除了结点，则树的结构改变，需要更新x.right

            } else if (com < 0) {//如果key小于x结点的键，就继续找x结点的左子树
                x.left = delete(x.left, key);
                //同理

            } else {//如果key等于x结点的键，就用要删除的结点x的右子树的最小结点代替 要删除的结点x
                //删除结点的逻辑: 令右子树中最小的结点minNode 替换被删除的结点

                if (x.right == null) { //若没有右结点，则令x的左结点代替X
                    return x.left;
                }

                if (x.left == null) {   //若没有左结点，则令x的右结点代替X
                    return x.right;
                }
                //以上两种情况特殊，和两边都有结点的情况不一样

                //如果左右结点都不为空，找有右子树的最小值来代替x；
                //找minNode：即右子树最左边的结点，只需要在右子树中一直找左子结点

                Node minNode = x.right;//默认为右子树的第一个
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                //删除minNode，
                Node n = x.right;
                while (n.left.left != null) {
                    if (n.left.left == null) { //即证明n为倒数第二个结点
                        n.left = null; //即删除了一个结点minNode
                    } else {
                        n = n.left; //如果还没到则继续向下更新n
                    }
                }
                //让x结点的左子树成为minNode的左子树
                minNode.left = x.left;
                //让x节点的右子树成为minNode的右子树
                minNode.right = x.right;
                //让x结点的父结点指向minNode
                x = minNode; //把x重新赋值为minNode，此时minNode的左右结点已更新

            }
            return x;
        }
    }

}
