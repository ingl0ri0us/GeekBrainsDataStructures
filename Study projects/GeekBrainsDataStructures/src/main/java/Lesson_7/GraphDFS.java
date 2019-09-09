package Lesson_7;

public class GraphDFS {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private  int[][] adjMat;
    private int size;
    private Stack stack;

    public GraphDFS() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for(int i = 0;i < MAX_VERTS; i++) {
            for(int j = 0; j < MAX_VERTS; j++) {
                adjMat [i][j] = 0;
            }
        }
        stack = new Stack(MAX_VERTS);
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if(adjMat [ver][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while(!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);

    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }


}
