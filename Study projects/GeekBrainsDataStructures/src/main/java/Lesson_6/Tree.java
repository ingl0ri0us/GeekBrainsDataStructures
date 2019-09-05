package Lesson_6;

import java.util.Stack;

public class Tree {
    private Node root;
    private String treeName;
    private int maxTreeHeight;

    public Tree() {
        root = null;
    }

    public Tree(String treeName, int maxTreeHeight) {
        root = null;
        this.treeName = treeName;
        this.maxTreeHeight = maxTreeHeight;
    }

    public Node getRoot() {
        return root;
    }

    public String getTreeName() {
        return treeName;
    }

    public Node find(int key) {
        Node current = root;
        while (current.number != key) {
            if (key < current.number) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, int number) {
        Node newNode = new Node();
        newNode.id = id;
        newNode.number = number;
        if (height(newNode) >= maxTreeHeight) return;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (height(parent) >= maxTreeHeight) {
                    return;
                }
                if (number < current.number) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.number != key) {
            parent = current;
            if (key < current.number) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        // Если узел не имеет потомков, удаляем
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        // Если нет правого потомка, узел заменяется левым поддеревом
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }

        // Если нет левого потомка, узел заменяется правым поддеревом
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {  // Если два потомка, узел зменяется преемником
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }
        return true;
    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    public void displayTree() {
        Stack golbalStack = new Stack();
        golbalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("..............................................................................");
        while (!isRowEmpty) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(' ');
            }
            while (!golbalStack.isEmpty()) {
                Node temp = (Node) golbalStack.pop();
                if (temp != null) {
                    temp.displayNode();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                golbalStack.push(localStack.pop());
            }
            System.out.println("..............................................................................");
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    public boolean isBalanced() {
        if (root.leftChild == null || root.rightChild == null) {
            return false;
        }
        int heightDifference = height(root.leftChild) - height(root.rightChild);
        if (Math.abs(heightDifference) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public int size(Node root) {
        if (root == null) return 0;

        return size(root.rightChild) + size(root.leftChild) + 1;
    }
}
















