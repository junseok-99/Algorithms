from collections import deque

def solution(people, limit):
    answer = deque()
    
    people.sort()
    people = deque(people)
    
    while (len(people) != 0):
        end = people.pop()
        tmp = limit - end
        
        if (len(people) > 0 and people[0] <= tmp):
            answer.append([end,people.popleft()])
        else:
            answer.append([end])
                
    return len(answer)