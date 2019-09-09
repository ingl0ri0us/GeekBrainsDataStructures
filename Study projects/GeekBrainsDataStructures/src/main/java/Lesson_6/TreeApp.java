package Lesson_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

public class TreeApp {
    public static void main(String[] args) throws IOException {

        double balancedCount = 0;

        for (int i = 1; i < 21; i++) {
            Tree tree = new Tree("Tree" + i, 4);
            for (int j = 1; j < 15; j++) {
                tree.insert(j, randomInt());
            }
            System.out.print(tree.getTreeName() + " has " + tree.size(tree.getRoot()) + " nodes and ");
            System.out.println(tree.isBalanced() ? " is balanced." : " is not balanced.");
            if (tree.isBalanced()) {
                balancedCount++;
            }
        }
        double unbalancedPercentage = 100 - (balancedCount / 20 * 100);
        System.out.println(unbalancedPercentage + " % of trees are unbalanced.");
    }

    public static int randomInt () {
        return ThreadLocalRandom.current().nextInt(-25, 26);
    }
}
// Часть кода из книжки, оставил для себя.
/*int value;
        Tree theTree = new Tree("Tree 1", 4);
        theTree.insert(1, randomInt());
        theTree.insert(2, randomInt());
        theTree.insert(3, randomInt());
        theTree.insert(4, randomInt());
        theTree.insert(5, randomInt());
        theTree.insert(6, randomInt());
        theTree.insert(7, randomInt());
        theTree.insert(8, randomInt());
        theTree.insert(9, randomInt());
        theTree.insert(10, randomInt());

        while (true) {
            System.out.print("Enter first letter of: show, ");
            System.out.print("insert, find, delete or traverse: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    System.out.println("Height of tree: " + theTree.height(theTree.getRoot()));
                    System.out.println(theTree.isBalanced());
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value, value * 2 + 13);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.println("Could not find ");
                        System.out.print(value + '\n');
                    }
                    break;
                case 'd':
                    System.out.println("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete) {
                        System.out.print("Deleted " + value + '\n');
                    } else {
                        System.out.print("Could not delete ");
                        System.out.print(value + '\n');
                    }
                    break;
                case 't':
                    System.out.println("Enter type 1, 2 or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }

        private static char getChar () throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static String getString () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        return s;
    }

    public static int getInt () throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    */