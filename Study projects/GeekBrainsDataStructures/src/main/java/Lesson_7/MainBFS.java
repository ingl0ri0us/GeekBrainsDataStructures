package Lesson_7;

public class MainBFS {
    public static void main(String[] args) {
        GraphBFS theGraph = new GraphBFS();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');
        theGraph.addVertex('K');
        theGraph.addVertex('L');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(0, 5);
        theGraph.addEdge(0, 7);
        theGraph.addEdge(7, 8);
        theGraph.addEdge(5, 6);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(8, 4);
        theGraph.addEdge(6, 9);
        theGraph.addEdge(2, 3);
        theGraph.addEdge(9, 4);
        theGraph.addEdge(3, 4);

        System.out.println("Visits: ");
        theGraph.bfs();
        System.out.println();
    }
}
