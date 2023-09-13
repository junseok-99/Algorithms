from sys import stdin
input = stdin.readline

s,e = input().split()
cnt = 1

while(int(s) < int(e)):
    if (e[len(e)-1] == '1'):
        t = list(e)
        t.pop()
        e = ''.join(t)
    else:
        if(int(e) % 2 != 0):
            break
        e = str(int(e) // 2)
    cnt += 1

if (s == e):
    print(cnt)
else:
    print(-1)
