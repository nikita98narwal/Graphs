#include <bits/stdc++.h>
using namespace std;
#define N 100001
using namespace std;
vector<int> v[N];
int D[N],n,m,ans=0;
void DFS(int x,int y, int count){
    if(D[y])
        count++;
    else
        count=0;
    if(count>m)
        return ;
    if(v[y].size()==1 && y!=0)
        ans++;
    for(int j=0;j<v[y].size();j++)
        if(v[y][j]!=x)
            DFS(y,v[y][j],count);
}
int main(){
    cin>>n>>m;
    for(int i=0;i<n;i++)
        cin>>D[i];
    for(int i=0;i<n-1;i++){
        int a,b;
        cin>>a>>b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    DFS(0,0,0);
        cout<<ans<<"\n";
}
