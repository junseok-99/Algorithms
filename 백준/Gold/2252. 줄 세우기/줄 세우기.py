import sys
input = sys.stdin.readline

def topologicalSort2(n,g):
    visited = ['no' for _ in range(n+1)]
    r=[]
    for i in range(1,n+1):
        if(visited[i] == 'no'):
            DFS_TS(visited,g,i,r)
    for i in range(n-1,-1,-1):
        print(r[i], end=' ')
            
def DFS_TS(visited,g,v,r):
    visited[v] = 'yes'
    for i in g[v]:
        if(visited[i] == 'no'):
            DFS_TS(visited,g,i,r)
    r.append(v)
            
n,m = map(int, input().split())
g = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int, input().split())
    g[a].append(b)
    
topologicalSort2(n,g)