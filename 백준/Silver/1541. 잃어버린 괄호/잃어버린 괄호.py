from sys import stdin

input = stdin.readline

s = input().strip()
t = ''
a = []

for i in range(len(s)):
    if (s[i] == '+' or s[i] == '-'):
        a.append(int(''+t))
        a.append(''+s[i])
        t = ''
        continue
    
    t += s[i]

    if i == len(s)-1:
        a.append(int(''+t))

while(len(a)!= 1):
    if (a.count('+')):
        i = a.index('+')
        ret = (a[i-1] + a[i+1])
        a.pop(i); a.pop(i); a.pop(i-1)
        a.insert(i-1,ret)
        continue
    
    if (a.count('-')):
        i = a.index('-')
        ret = (a[i-1] - a[i+1])
        a.pop(i); a.pop(i); a.pop(i-1)
        a.insert(i-1,ret)
        
        
print(a[0])