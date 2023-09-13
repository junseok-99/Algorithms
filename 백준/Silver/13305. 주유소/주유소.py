from sys import stdin

n = int(stdin.readline().strip())
dist = list(map(int,stdin.readline().split()))
cost = list(map(int,stdin.readline().split()))

m_d = cost[0]
s_d = dist[0] * cost[0]

for i in range(1,n-1):
    if (cost[i] < m_d):
        m_d = cost[i]
        
    s_d += dist[i] * m_d
    
print(s_d)
