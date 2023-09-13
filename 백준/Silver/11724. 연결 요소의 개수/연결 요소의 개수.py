import sys
sys.setrecursionlimit(100000)

input = sys.stdin.readline

n,m = map(int, input().split())

g = [[] for _ in range(n+1)]
vt = [False for _ in range(n+1)]
cnt = 0

def dfs(num):
    vt[num] = True
    for k in g[num]:
        if(vt[k] == False):
            dfs(k)
                
for _ in range(m):
    a,b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)
    
for i in range(1,n+1):
    if(vt[i] == False):
        cnt += 1
        dfs(i)

print(cnt)