#include<bits/stdc++.h>
using namespace std;

class graph
{
private:
    vector<int> g[10001];
    int n,m;

public:
    graph(int a, int b)
    {
        n = a;
        m = b;
    }

    // Function to create graph with N*M nodes
    // considering each cell as a node and each
    // boundary as an edge.
    void createGraph()
    {
        int k = 1;  // A number to be assigned to a cell

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // If last row, then add edge on right side.
                if (i == n)
                {
                    // If not bottom right cell.
                    if (j != m)
                    {
                        g[k].push_back(k+1);
                        g[k+1].push_back(k);
                    }
                }

                    // If last column, then add edge toward down.
                else if (j == m)
                {
                    g[k].push_back(k+m);
                    g[k+m].push_back(k);
                }

                    // Else make edge in all four direction.
                else
                {
                    g[k].push_back(k+1);
                    g[k+1].push_back(k);
                    g[k].push_back(k+m);
                    g[k+m].push_back(k);
                }

                k++;
            }
        }
    }

    // BFS function to find minimum distance
    void bfs(bool visit[], int dist[], queue<int> q)
    {
        while (!q.empty())
        {
            int temp = q.front();
            q.pop();

            for (int i = 0; i < g[temp].size(); i++)
            {
                if (visit[g[temp][i]] != 1)
                {
                    dist[g[temp][i]] =
                            min(dist[g[temp][i]], dist[temp]+1);

                    q.push(g[temp][i]);
                    visit[g[temp][i]] = 1;
                }
            }
        }
    }

    // Printing the solution.
    void print(int dist[])
    {
        for (int i = 1, c = 1; i <= n*m; i++, c++)
        {
            cout << dist[i] << " ";
        }
        cout<<endl;
    }
};



int main()
{

    int t;
    cin>>t;
    while(t--)
    {
        int n,m;
        cin>>n>>m;
        bool mat[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                cin>>mat[i][j];
        }
        graph g1(n, m);
        g1.createGraph();

        // To store minimum distance
        int dist[10001];

        // To mark each node as visited or not in BFS
        bool visit[10001] = { 0 };

        // Initialising the value of distance and visit.
        for (int i = 1; i <= m*n; i++)
        {
            dist[i] = INT_MAX;
            visit[i] = 0;
        }

        // Inserting nodes whose value in matrix
        // is 1 in the queue.
        int k = 1;
        queue<int> q;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (mat[i][j] == 1)
                {
                    dist[k] = 0;
                    visit[k] = 1;
                    q.push(k);
                }
                k++;
            }
        }

        // Calling for Bfs with given Queue.
        g1.bfs(visit, dist, q);

        // Printing the solution.
        g1.print(dist);

    }
    return 0;
}
