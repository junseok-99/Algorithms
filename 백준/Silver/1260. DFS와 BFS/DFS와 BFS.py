from sys import stdin

n,m,num = map(int,stdin.readline().split())
maps = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
ret = []

for _ in range(m):
    s,d = map(int,stdin.readline().split())
    maps[s].append(d)
    maps[d].append(s)

for i in range(1,n+1):
    maps[i].sort()

def dfs(node):
    if(visited[node] == True):
        return
    else:
        visited[node] = True
        ret.append(node)
        for i in maps[node]:
            dfs(i)

def bfs(node):
    visited[node] = True
    q = []
    q.append(node)
    while(len(q) != 0):
        tmp = q.pop(0)
        ret.append(0+tmp)
        for i in maps[tmp]:
            if(visited[i] == False):
                visited[i] = True
                q.append(i)
    
dfs(num)
print(' '.join(map(str,ret)))
ret = []
visited = [False for _ in range(n+1)]
bfs(num)
print(' '.join(map(str,ret)))
