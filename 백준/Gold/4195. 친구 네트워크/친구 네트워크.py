from sys import stdin

n = int(stdin.readline().rstrip())
s=''

def unions(a,b):
    x = find(a)
    y = find(b)

    if x == y:
        return
    nodes[y] = x
    values[x] += values[y]

def find(x):
    if nodes[x] == x:
        return x
    nodes[x] = find(nodes[x])
    return nodes[x]

for _ in range(n):
    m = int(stdin.readline().rstrip())
    nodes = dict()
    values = dict()
    for _ in range(m):
    
        tmp1,tmp2 = map(str,stdin.readline().split())
    
        if tmp1 not in nodes:
            nodes[tmp1] = tmp1
            values[tmp1] = 1
        if tmp2 not in nodes:
            nodes[tmp2] = tmp2
            values[tmp2] = 1               
                
        unions(nodes[tmp1],nodes[tmp2])
        
        s+=(str(values[find(tmp1)])+'\n')
        
print(s)