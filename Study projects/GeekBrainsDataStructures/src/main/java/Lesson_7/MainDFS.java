package Lesson_7;

public class MainDFS {
    public static void main(String[] args) {
        GraphDFS theGraph = new GraphDFS();

        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(3,4);

        System.out.println("Visits: ");
        theGraph.dfs();
    }
}
