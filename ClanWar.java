import java.util.*;


    public class Main {
        enum Color{
            WHITE, RED, GREEN
        }

        static class Graph {
            int vertices;
            LinkedList<Integer>[] adjList;

            public Graph(int vertices) {
                this.vertices = vertices;

                adjList = new LinkedList[vertices];
                //Initialize lists
                for (int i = 0; i < vertices; i++) {
                    adjList[i] = new LinkedList<>();
                }
            }

            public void addEdge(int source, int destination) {
                //add forward edge
                adjList[source].addFirst(destination);

                //add back edge
                adjList[destination].addFirst(source);
            }

            public boolean isBipartite(Graph graph) {

                //check if graph is empty
                if (graph.vertices == 0)
                    return true;

                //initialize colors for all vertices
                Color colors[] = new Color[vertices];
                //color all the vertices with white color
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = Color.WHITE;
                }

                Queue<Integer> queue = new LinkedList<>();
                //start coloring vertices , this code will handle the disconnected graph as well
                //color the first vertex with RED
            for (int source = 0; source < vertices; source++) {

                    if (colors[source] == Color.WHITE) {
                        colors[source] = Color.RED;

                        //add it to queue for BFS

                        queue.add(source);

                 while (!queue.isEmpty()) {
                    int v = queue.remove();
                    for (int i = 0; i < adjList[v].size(); i++) {
                        int dest = adjList[v].get(i);

                        if (colors[dest] == Color.WHITE) {

                            if (colors[v] == Color.RED) {                     
                            colors[dest] = Color.GREEN;
                            } 
                    else if (colors[v] == Color.GREEN)
                     {
                        colors[dest] = Color.RED;
                     }
                    queue.add(dest);
                } 
                else if (colors[v] == colors[dest]) {

                    return false;
                    }
                }
            }
        }
    }  
                return true;
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
            int n = sc.nextInt();
            int e = sc.nextInt();
            Graph graph = new Graph(n);
            while(e-->0)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.addEdge(u,v);

            }

            boolean result = graph.isBipartite(graph);
            if(result)
            System.out.println("Yes");
            else
            System.out.println("No");
            }


        }

    }
