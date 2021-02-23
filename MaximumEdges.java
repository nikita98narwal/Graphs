 import java.util.*;

    public class Main {
         public static void main(String[] args) 
         {
            Scanner sc=new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
            int n=sc.nextInt();
            int m=sc.nextInt();
            ArrayList<ArrayList<Integer>> g=new ArrayList<>();
            for(int i=0;i<=n;i++)
            g.add(new ArrayList<Integer>());
            for(int i=0;i<m;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                g.get(u).add(v);
                g.get(v).add(u);
            }
            int max=Integer.MIN_VALUE;
            boolean vis[]=new boolean[n+1];
            for(int i=1;i<=n;i++){
                if(!vis[i]){
                    int res=(dfs(g,i,vis));
                    max=Math.max(res/2,max);
                }
            }
            System.out.println(max);
            }
         }
        static int dfs(ArrayList<ArrayList<Integer>> g,int s,boolean vis[]){
            int edge=g.get(s).size();
            vis[s]=true;
        for (int i=0;i<g.get(s).size();i++) {  
            if (vis[g.get(s).get(i)]==false){  
                edge+=dfs(g,g.get(s).get(i),vis);  
            }  
        }
        return edge;
        }

    }
