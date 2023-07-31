from sys import stdin

n = int(stdin.readline().rstrip())
m = int(stdin.readline().rstrip())

node = list(range(n+1))

def union(a,b):
    x,y = find(a),find(b)
    
    if node[x] == node[y]:
        return
    node[y] = x
def find(x):
    if node[x] == x:
        return x
    node[x] = find(node[x])
    return node[x]

for i in range(n):
    tmp = list(map(int,stdin.readline().split()))
    for j in range(len(tmp)):
        if tmp[j]==1:
            union(i+1,j+1)

tmp = list(map(int,stdin.readline().split()))
start = tmp.pop(0)
flag = True
for dest in tmp:
    if(find(start) == find(dest)):
        start = dest
    else:
        flag = False
        break
if flag:
    print('YES')
else:
    print('NO')