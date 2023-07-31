import sys
sys.setrecursionlimit(100000)

input = sys.stdin.readline

n = int(input().strip())
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def dfs(y,x,g,w,h):
    if (g[y][x] != 1):
        return
    else:
        g[y][x] = -1
        for k in range(4):
            my = y + dy[k]
            mx = x + dx[k]
            if (0 <= my < h and 0 <= mx < w):
                if(g[my][mx] == 1):
                    dfs(my,mx,g,w,h)
for _ in range(n):
    w,h,p = map(int, input().split())
    cnt = 0

    g = [ [0 for _ in range(w)] for _ in range(h)]

    for _ in range(p):
        x,y = map(int, input().split())
        g[y][x] = 1

    for i in range(h):
        for j in range(w):
            if (g[i][j] == 1):
                cnt += 1
                dfs(i,j,g,w,h)

    print(cnt)
