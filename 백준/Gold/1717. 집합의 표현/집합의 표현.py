from sys import stdin

n,m = map(int,stdin.readline().split())

node = [ i for i in range(n+1)]

def union(a,b):
    x = find(a)
    y = find(b)

    if x == y:
        return
    else:
        node[y] = x

def find(x):
    if node[x] == x:
        return x
    node[x] = find(node[x])
    return node[x]

for _ in range(m):
    k,a,b = map(int,stdin.readline().split())
    if k == 0:
        union(a,b)
    else:
        if find(a) == find(b):
            print('YES')
        else:
            print('NO')