package com.datastructure.tree;
public class BinarySearchTree<Key extends Comparable<Key>,Value> {
    private Node root; // 记录根节点
    private int N; // 记录树中元素的个数
    private class Node {
        private Key key; // 存储键
        private Value value; // 存储值
        private Node left; // 记录左子节点
        private Node right; // 记录右子节点
        public Node(Key key,Value value,Node left,Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public int size() {  // 获取树中元素个数
        return N;
    }

    // 构造函数，初始化一个空的二叉查找树
    public BinarySearchTree() {
        root = null;
    }

    // 添加
    public void put(Key key,Value value) {  // 向树中添加元素 key-value
        root = put(root,key,value);
    }
    private Node put(Node node,Key key,Value value) { // 向指定的树x中添加key-value,并返回添加元素后新的树
        if (node == null) {
            N++;
            return new Node(key,value,null,null);
        }
        int cmp = key.compareTo(node.key); // 如果node子树不为空，比较node结点的键和key的大小
        if (cmp > 0) {  // 如果key大于node结点的键，则继续找node结点的右子树
            node.right = put(node.right,key,value);
        } else if (cmp < 0) {  // 如果key小于node结点的键，则继续找node结点的左子树
            node.left = put(node.left,key,value);
        } else {  // 如果key等于node结点的键，则替换node结点的值为value即可
            node.value = value;
        }
        return node;
    }

    // 查找
    public Value get(Key key) { // 查询树中指定key对应的value
        return get(root,key);
    }
    private Value get(Node node,Key key) { // 从指定的树node中，查找key对应的值
        if (node == null) { // node树为null
            return null;
        }
        int cmp = key.compareTo(node.key); // node树不为null，比较key和node结点的键的大小
        if (cmp > 0) {
            return get(node.right,key);  // 如果key大于node结点的键，则继续找node结点的右子树
        } else if (cmp < 0) {
            return get(node.left,key);  // 如果key小于node结点的键，则继续找node结点的左子树
        } else {
            return node.value; // 如果key等于node结点的键，就找到了键为key的结点，只需要返回node结点的值即可
        }
    }

    // 删除
    public void delete(Key key) {
        root = delete(root,key);
    }
    private Node delete(Node node,Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = delete(node.right,key);
        } else if (cmp < 0) {
            node.left = delete(node.left,key);
        } else {
            N--;
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            } else {
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = deleteMin(node.right);
            }
        }
        return node;
    }
    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(5, "A");
        bst.put(3, "B");
        bst.put(7, "C");
        bst.put(2, "D");
        bst.put(4, "E");

        System.out.println("N: "+ bst.size() + "   Value for key 7: " + bst.get(7)); // Output: C

        bst.delete(3);
        System.out.println("N: "+ bst.size() + "   Value for key 3 after deletion: " + bst.get(3)); // Output: null
    }
}