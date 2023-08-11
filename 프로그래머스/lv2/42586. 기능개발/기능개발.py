from collections import deque

def solution(pro, speeds):
    answer = []
    pro = deque(pro)
    speeds = deque(speeds)
    
    while(len(pro) != 0):
        cnt = 0
        while(len(pro) > 0 and pro[0] > 99):
            pro.popleft()
            speeds.popleft()
            cnt += 1
            
        if cnt > 0:
            answer.append(0+cnt)
        
        for i in range(len(pro)):
            pro[i] += speeds[i]
            
    return answer