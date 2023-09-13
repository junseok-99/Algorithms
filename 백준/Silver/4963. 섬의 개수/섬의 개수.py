import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

dx,dy = [1,0,-1,0,1,1,-1,-1],[0,1,0,-1,1,-1,-1,1]
def dfs(m,y,x,w,h):
    m[y][x] = 0
    for i in range(8):
        mx,my = x + dx[i], y + dy[i]
        if(0 <= mx < w and 0 <= my < h and m[my][mx] == 1):
            dfs(m,my,mx,w,h)

while (True):
    w,h = map(int,input().split())
    cnt = 0
    if(w == 0 and h == 0):
        break
    maps = []
    for _ in range(h):
        maps.append(list(map(int, input().split())))

    for j in range(h):
        for k in range(w):
            if(maps[j][k] == 1):
                cnt += 1
                dfs(maps,j,k,w,h)
    print(cnt)
