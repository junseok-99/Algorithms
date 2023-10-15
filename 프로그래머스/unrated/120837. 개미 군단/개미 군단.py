def solution(hp):
    answer = 0
    t = [5,3,1]
    
    for i in t:
        answer += hp // i
        hp %= i
    
    return answer