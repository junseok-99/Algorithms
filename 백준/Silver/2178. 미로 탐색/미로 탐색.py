from sys import stdin

n,m = map(int,stdin.readline().split())

visited = [ [False for _ in range(m)] for _ in range(n)]
maps = [[] for _ in range(n)]

for i in range(n):
    tmp = stdin.readline().rstrip()
    for j in tmp:
        maps[i].append(int(j))

def bfs(coord):
    y,x = coord
    prev = 0
    visited[y][x] = True
    q=[]
    q.append(coord)
    while(len(q) != 0):
        tmp = q.pop(0)
        y,x = tmp
        prev = maps[tmp[0]][tmp[1]]
        for i in range(-1,2,2):
            if(x+i >=0 and x+i<m):
                if(visited[y][x+i] == False):
                    visited[y][x+i] = True
                    if(maps[y][x+i] != 0):
                        maps[y][x+i] += prev
                        q.append((y,x+i))
            if(y+i >=0 and y+i<n):
                if(visited[y+i][x] == False):
                    visited[y+i][x] = True
                    if(maps[y+i][x] != 0):
                        maps[y+i][x] += prev
                        q.append((y+i,x))
    print(maps[n-1][m-1])
                
bfs((0,0))

