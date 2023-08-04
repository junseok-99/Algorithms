n=int(input())

for _ in range(n):
    arr=list(map(str, input()))
    num = 1
    sums = 0
    
    for i in arr:
        if(i=='O'):
            sums+=num
            num+=1
        else:
            num=1
            
    print(sums)