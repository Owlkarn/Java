package Sem_4_1;

import java.util.ArrayList;
import java.util.List;

public class BinTree<T extends Comparable<T>> {
    Node root;

    public boolean add(T value) {
        if (root == null) {
            Node newNode = new Node(value);
            root = newNode;
            root.color = Color.Black;
            return true;
        }
        if (addNode(root, value) != null)
            return true;
        return false;
    }

    private Node addNode(Node node, T value) {
        if (node.value.compareTo(value) == 0)
            return null;
        if (node.value.compareTo(value) > 0) {
            if (node.left == null) {
                node.left = new Node(value);
                return node.left;
            }
            Node resultNode = addNode(node.left, value);
            node.left = rebalanced(node.left);
            return resultNode;
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                return node.right;
            }
            Node resultNode = addNode(node.right, value);
            node.right = rebalanced(node.right);
            return resultNode;
        }
    }

    public boolean remove(T value) {
        if (!contains(value))
            return false;
        root = removeNode(root, value);
        return true;
    }

    private Node removeNode(Node node, T value) {
        if (node == null)
            return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0)
            node.left = removeNode(node.left, value);
        else if (cmp > 0)
            node.right = removeNode(node.right, value);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            Node minNode = findMinNode(node.right);
            node.value = minNode.value;
            node.right = removeNode(node.right, minNode.value);
        }
        return rebalanced(node);
    }

    private Node findMinNode(Node node) {
        if (node.left == null)
            return node;
        return findMinNode(node.left);
    }

    public boolean contains(T value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value.equals(value))
                return true;
            if (currentNode.value.compareTo(value) > 0)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

    private Node rebalanced(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.Red
                    && (result.left == null || result.left.color == Color.Black)) {
                needRebalance = true;
                result = rotateLeft(result);
            }
            if (result.left != null && result.left.color == Color.Red
                    && result.left.left != null && result.left.left.color == Color.Red) {
                needRebalance = true;
                result = rotateRight(result);
            }
            if (result.left != null && result.left.color == Color.Red
                    && result.right != null && result.right.color == Color.Red) {
                needRebalance = true;
                flipColors(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = Color.Red;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = Color.Red;
        return x;
    }

    private void flipColors(Node node) {
        node.color = Color.Red;
        node.left.color = Color.Black;
        node.right.color = Color.Black;
    }

    private class Node {
        T value;
        Color color;
        Node left;
        Node right;

        Node() {
            color = Color.Red;
        }

        Node(T _value) {
            this.value = _value;
            left = null;
            right = null;
            color = Color.Red;
        }
    }

    enum Color {
        Red, Black
    }

    private class PrintNode {
        Node node;
        String str;
        int depth;

        public PrintNode() {
            node = null;
            str = " ";
            depth = 0;
        }

        public PrintNode(Node node) {
            depth = 0;
            this.node = node;
            this.str = node.value.toString();
        }

        public void set(int _depth, String _str) {
            depth = _depth;
            str = _str;
        }
    }

    public void print() {
        int maxDepth = maxDepth() + 3;
        int nodeCount = nodeCount(root, 0);
        int width = nodeCount * 4 + 2;
        int height = maxDepth * 2 + 1;
        List<List<PrintNode>> list = new ArrayList<List<PrintNode>>();
        for (int i = 0; i < height; i++) {
            ArrayList<PrintNode> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(new PrintNode());
            }
            list.add(row);
        }

        list.get(height / 2).set(0, new PrintNode(root));
        list.get(height / 2).get(0).depth = 0;

        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                PrintNode currentNode = list.get(i).get(j);
                if (currentNode.node != null) {
                    currentNode.str = currentNode.node.value.toString();
                    if (currentNode.node.left != null) {
                        int in = i + (maxDepth / (int) Math.pow(2, currentNode.depth));
                        int jn = j + 3;
                        printLines(list, i, j, in, jn);
                        list.get(in).get(jn).node = currentNode.node.left;
                        list.get(in).get(jn).depth = list.get(i).get(j).depth + 1;

                    }
                    if (currentNode.node.right != null) {
                        int in = i - (maxDepth / (int) Math.pow(2, currentNode.depth));
                        int jn = j + 3;
                        printLines(list, i, j, in, jn);
                        list.get(in).get(jn).node = currentNode.node.right;
                        list.get(in).get(jn).depth = list.get(i).get(j).depth + 1;
                    }

                }
            }
        }
        for (int i = 0; i < height; i++) {
            boolean flag = true;
            for (int j = 0; j < width; j++) {
                if (list.get(i).get(j).str != " ") {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.remove(i);
                i--;
                height--;
            }
        }

        for (var row : list) {
            for (var item : row) {
                System.out.print(item.str + " ");
            }
            System.out.println();
        }
    }

    private void printLines(List<List<PrintNode>> list, int i, int j, int i2, int j2) {
        if (i2 > i) {
            while (i < i2) {
                i++;
                list.get(i).get(j).str = "|";
            }
            list.get(i).get(j).str = "\\";
            while (j < j2) {
                j++;
                list.get(i).get(j).str = "-";
            }
        } else {
            while (i > i2) {
                i--;
                list.get(i).get(j).str = "|";
            }
            list.get(i).get(j).str = "/";
            while (j < j2) {
                j++;
                list.get(i).get(j).str = "-";
            }
        }
    }

    private int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null)
            return 0;
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private int nodeCount(Node node, int count) {
        if (node == null)
            return count;
        count++;
        count = nodeCount(node.left, count);
        count = nodeCount(node.right, count);
        return count;
    }
}
