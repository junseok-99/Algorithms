from sys import stdin

input = stdin.readline

N = int(input().strip())

a,b = list(map(int, input().split())),list(map(int, input().split()))
ta,tb = [0 for _ in range(N)], [] + b

for _ in range(N):
     mx = max(b)
     bi = b.index(mx)
     b[bi] = -1
     mi = min(a)
     a.remove(mi)
     ta[bi] = mi

ret = 0

for i in range(N):
    ret += (ta[i] * tb[i])

print(ret)