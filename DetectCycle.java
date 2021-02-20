import java.util.*;
  import java.io.*;
  class Graph{
    int[][] AdjMatrix;
    int size;
    Graph(int size)
    {
      this.size=size;
      AdjMatrix=new int[size][size];
    }
    void add(int start,int end)
    {
      AdjMatrix[start][end]=1;
      AdjMatrix[end][start]=1;
    }
    boolean checkcycle(int current,int parent,boolean[] visited)
    {
      visited[current]=true;
      for(int i=0;i<size;i++)
      {
        if(AdjMatrix[current][i]==1 && !visited[i])
        {
          if(checkcycle(i,current,visited))
          return true;
        }
        else if(AdjMatrix[current][i]==1 && i!=parent)
        return true;
      }
      return false;
    }
    boolean iscyclic()
    {
      boolean visited[]=new boolean[size];
      for(int i=0;i<size;i++)
      visited[i]=false;
      for(int i=0;i<size;i++)
      {
        if(visited[i]==false)
        {
          if(checkcycle(i,-1,visited))
          return true;
        }
      }
      return false;
    }
  }
  public class Main {
    public static void main(String args[]) throws IOException {
      
      
      //write your code here
       Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      long m=sc.nextLong();
      int u,v;
      Graph g=new Graph(n);
      for(long i=0;i<m;i++)
      {
        u=sc.nextInt();
        v=sc.nextInt();
        g.add(u,v);
      }
      if(g.iscyclic())
      System.out.println("Yes");
      else
      System.out.println("No");
    }
  }
