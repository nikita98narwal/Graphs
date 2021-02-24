 import java.util.*; 

    class Main { 

        static class Pair<T,V> { 
            T first; 
            V second; 

            Pair(T first, V second) { 
                this.first = first; 
                this.second = second; 
            } 
        } 


        static class Graph { 
            int V; 
            LinkedList<Integer>[] adj; 

            // Constructor 
            Graph(int V) { 
                this.V = V; 
                adj = new LinkedList[V]; 
                for(int i = 0; i < V; ++i) { 
                    adj[i] = new LinkedList<Integer>(); 
                } 
            } 

            void addEdge(int s, int d) { 
                adj[s].add(d); 
                adj[d].add(s); 
            } 

            Pair<Integer, Integer> bfs(int u) { 
                int[] dis = new int[V]; 

                Arrays.fill(dis, -1); 

                Queue<Integer> q = new LinkedList<>(); 

                q.add(u); 

                dis[u] = 0; 
                while (!q.isEmpty()) { 
                    int t = q.poll(); 

                    for(int i = 0; i < adj[t].size(); ++i) { 
                        int v = adj[t].get(i); 

                        if(dis[v] == -1) { 
                            q.add(v); 

                            dis[v] = dis[t] + 1; 
                        } 
                    } 
                } 

                int maxDis = 0; 
                int nodeIdx = 0; 

                for(int i = 0; i < V; ++i) { 
                    if(dis[i] > maxDis) { 
                        maxDis = dis[i]; 
                        nodeIdx = i; 
                    } 
                } 

                return new Pair<Integer, Integer>(nodeIdx, maxDis); 
            } 

            void longestPathLength() { 
                Pair<Integer, Integer> t1, t2; 
                t1 = bfs(0); // first bfs

                // second bfs to find actual longest path 
                t2 = bfs(t1.first); 

                System.out.println(t2.second); 
            } 
        } 

        public static void main(String[] args){ 
            // Create a graph given in the example 
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


            graph.longestPathLength(); 
            }
        } 

        } 
