import sys
import copy

sys.setrecursionlimit(100000)
input = sys.stdin.readline

dy,dx = [-1,0,1,0], [0,1,0,-1]
cnt = [0,0]
n = int(input().strip())

m = [list(map(str, input().strip())) for _ in range(n)]
mc = copy.deepcopy(m)

for i in range(n):
    for j in range(n):
        if mc[i][j] == 'G':
            mc[i][j] = 'R'

def dfs(c,t,y,x):
    t[y][x] = 'v'
    for i in range(4):
        my,mx = y + dy[i], x + dx[i]
        if(0 <= my < n and 0 <= mx < n and t[my][mx] == c):
            dfs(c,t,my,mx)
        
def search(cnt,c):
    for j in range(n):
        for k in range(n):
            if m[j][k] != 'v':
                cnt[c] += 1
                dfs(m[j][k],m,j,k)
                    
search(cnt,0)
m = mc
search(cnt,1)
print(cnt[0],cnt[1], end = ' ')
