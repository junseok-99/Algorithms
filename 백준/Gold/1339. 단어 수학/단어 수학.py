from sys import stdin

input = stdin.readline

n = int(input().strip())
w = [input().strip() for _ in range(n)]
s = 9
a = [0 for _ in range(26)]
ret = 0

for i in w:
    for j in range(len(i)-1,-1,-1):
        a[abs(ord('A') - ord(i[len(i)-j-1]))] += 10**j

a.sort(reverse=True)

for num in a:
    if num == 0:
        break
    ret += (num*s)
    s -= 1

print(ret)