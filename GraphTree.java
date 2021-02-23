import java.io.*; 
    import java.util.*; 


    class Graph 
    { 
        private int V; // No. of vertices 
        private LinkedList<Integer> adj[]; //Adjacency List 

    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 

    // Function to add an edge into the graph 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
        adj[w].add(v); 
    } 

    Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
    { 
        visited[v] = true; 
        Integer i; 

        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 

            if (!visited[i]) 
            { 
                if (isCyclicUtil(i, visited, v)) 
                    return true; 
            } 

            else if (i != parent) 
            return true; 
        } 
        return false; 
    } 

    Boolean isTree() 
    { 
        Boolean visited[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 

        if (isCyclicUtil(0, visited, -1)) 
            return false; 

        for (int u = 0; u < V; u++) 
            if (!visited[u]) 
                return false; 

        return true; 
    } 

    public static void main(String args[]) 
    { 
      Scanner sc = new Scanner(System.in);
      int t= sc.nextInt();
      while(t-- !=0)
      {
        int n,e;
        n = sc.nextInt();
        e = sc.nextInt();

        Graph g1 = new Graph(n); 
        while(e--!=0)
        {
          int u,v;
          u = sc.nextInt();
          v = sc.nextInt();
        g1.addEdge(u,v); 

        }
        if (g1.isTree()) 
            System.out.println("YES"); 
        else
            System.out.println("NO"); 
      } 
     } 
    } 
