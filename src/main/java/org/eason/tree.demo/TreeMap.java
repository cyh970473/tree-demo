package org.eason.tree.demo;

import java.util.Comparator;

/**
 * @Desc: 二叉查找树
 * @DateTime: 2018/9/19 16:02
 * @Author chen
 * @Version 1.0
 */
public class TreeMap<K, V> {
    private Comparator<? super K> comparator;
    private Node<K, V> root;
    private int size = 0;

    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public Node<K, V> put(K key, V value) {
        Node<K, V> p = root;
        if(root == null) {
            root = new Node<K, V>().setKey(key).setValue(value);
            size = 1;
            return root;
        }
        Node<K, V> n = null;
        int compareNum = 0;
        while (p != null) {
            n = p;
            compareNum = comparator.compare(key, p.getKey());
            if(compareNum < 0)
                p = p.getLeftNode();
            else if(compareNum > 0)
                p = p.getRightNode();
            else
                return p.setValue(value);
        }
        Node<K, V> newNode = new Node<K, V>().setParentNode(n).setKey(key).setValue(value);
        if(compareNum < 0)
            n.setLeftNode(newNode);
        else
            n.setRightNode(newNode);
        size++;
        return null;
    }

    public V get(K key) {
        Node<K, V> p = root;
        while(p != null) {
            int compare = comparator.compare(key, p.getKey());
            if(compare < 0)
                p = p.getLeftNode();
            else if(compare > 0)
                p = p.getRightNode();
            else
                return p.getValue();
        }
        return null;
    }

    public V remove(K key) {
        Node<K, V> p = root;
        while(p != null) {
            int compare = comparator.compare(key, p.getKey());
            if(compare < 0)
                p = p.getLeftNode();
            else if(compare > 0)
                p = p.getRightNode();
            else
                break;
        }
        if(p != null) {
            size--;
            if(p.getLeftNode() == null && p.getRightNode() == null) {
                if(p.getParentNode() == null) {
                    root = null;
                } else {
                    if(p == p.getParentNode().getLeftNode())
                        p.getParentNode().setLeftNode(null);
                    else if(p == p.getParentNode().getRightNode())
                        p.getParentNode().setRightNode(null);
                    p.setParentNode(null);
                }
            } else if(p.getRightNode() != null) {
                Node<K, V> target = p;
                Node<K, V> left = target.getLeftNode();
                Node<K, V> right = target.getRightNode();
                Node<K, V> parent = target.getParentNode();
                Node<K, V> rightMin;
                do {
                    rightMin = right;
                    right = right.getLeftNode();
                } while(right != null);
                rightMin.setParentNode(parent);
                if(target == parent.getLeftNode())
                    parent.setLeftNode(rightMin);
                else if(target == parent.getRightNode())
                    parent.setRightNode(rightMin);
                if(left != null) {
                    rightMin.setLeftNode(left);
                    left.setParentNode(rightMin);
                }
                target.setParentNode(null);
                target.setLeftNode(null);
            } else if(p.getLeftNode() != null) {
                Node<K, V> target = p;
                Node<K, V> left = target.getLeftNode();
                Node<K, V> parent = target.getParentNode();
                left.setParentNode(parent);
                if(target == parent.getLeftNode())
                    parent.setLeftNode(left);
                else if(target == parent.getRightNode())
                    parent.setRightNode(left);
                target.setParentNode(null);
                target.setLeftNode(null);
            }
            return p.getValue();
        }
        return null;
    }

    public boolean containsKey(K key) {
        Node<K, V> p = root;
        while(p != null) {
            int compare = comparator.compare(key, p.getKey());
            if(compare < 0)
                p = p.getLeftNode();
            else if(compare > 0)
                p = p.getRightNode();
            else
                return true;
        }
        return false;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node<K, V> successor(Node<K, V> t) {
        if(t == null)
            return null;
        else if(t.getRightNode() != null) {
            Node<K, V> r = t.getRightNode();
            while(r.getLeftNode() != null)
                r = r.getLeftNode();
            return r;
        } else {
            Node<K, V> p = t.getParentNode();
            Node<K, V> ch = t;
            while(p != null && ch == p.getRightNode()) {
                ch = p;
                p = p.getParentNode();
            }
            return p;
        }
    }
}
