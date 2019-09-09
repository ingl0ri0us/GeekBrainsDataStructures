package Lesson_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashChainApp {
    public static void main(String[] args) throws IOException {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;

        System.out.println("Enter size of hash table: ");
        size = getInt();
        System.out.println("Enter initial number of items: ");
        n = getInt();

        HashTable theHastTable = new HashTable(size);

        for (int j = 0; j < n; j++) {
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            theHastTable.insert(aDataItem);
        }

        boolean quit = false;
        while (!quit) {
            System.out.println("Enter first letter of ");
            System.out.println("show, insert, delete, find or quit: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHastTable.displayTable();
                    break;
                case 'i':
                    System.out.println("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    theHastTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.println("Enter key value to delete: ");
                    aKey = getInt();
                    theHastTable.delete(aKey);
                    break;
                case 'f':
                    System.out.println("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHastTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                        break;
                    }
                case 'q':
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid entry \n");
            }
        }
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
