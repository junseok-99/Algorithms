n = int(input())
dp = [0 for i in range(12)]
dp[1] = 1
dp[2] = 2
dp[3] = 4

for _ in range(n):
    x = int(input())
    for i in range(4,x+1):
        dp[i]=(dp[i-1] + dp[i-2] + dp[i-3])
        
    print(dp[x])