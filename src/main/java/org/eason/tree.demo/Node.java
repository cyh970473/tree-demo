package org.eason.tree.demo;

/**
 * @Desc: 树节点
 * @DateTime: 2018/9/19 16:01
 * @Author chen
 * @Version 1.0
 */
public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> parentNode;
    private Node<K, V> leftNode;
    private Node<K, V> rightNode;

    public K getKey() {
        return key;
    }

    public Node<K, V> setKey(K key) {
        this.key = key;
        return this;
    }

    public V getValue() {
        return value;
    }

    public Node<K, V> setValue(V value) {
        this.value = value;
        return this;
    }

    public Node<K, V> getParentNode() {
        return parentNode;
    }

    public Node<K, V> setParentNode(Node parentNode) {
        this.parentNode = parentNode;
        return this;
    }

    public Node<K, V> getLeftNode() {
        return leftNode;
    }

    public Node<K, V> setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
        return this;
    }

    public Node<K, V> getRightNode() {
        return rightNode;
    }

    public Node<K, V> setRightNode(Node rightNode) {
        this.rightNode = rightNode;
        return this;
    }

    @Override
    public String toString() {
        return "[" + key + "," + value + "]";
    }
}
