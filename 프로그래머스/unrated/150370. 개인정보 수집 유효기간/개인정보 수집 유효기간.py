def solution(today, terms, privacies):
    answer = []
    
    t_dic = dict()
    today = list(map(int, today.split('.')))
    
    for term in terms:
        tmp = term.split()
        t_dic[tmp[0]] = int(tmp[1])
        
    for i in range(len(privacies)):
        tmp = privacies[i].split()
        day = list(map(int,tmp[0].split('.')))
        y,m,d = day[0],day[1],day[2]
        
        m += t_dic[tmp[1]]
        d -= 1
        
        if (m % 12 != 0):
            if m > 12:
                y += (m // 12)
                m %= 12
        else:
            y += (m // 12)
            y -= 1
            m = 12
            
        if d == 0:
            d = 28
            m -= 1
            
        if m == 0:
            y -= 1
            m = 12    
        if today[0] > y:
            answer.append(i+1)
            continue
        elif today[0] == y:
            if today[1] > m:
                answer.append(i+1)
                continue
            elif today[1] == m:
                if today[2] > d:
                    answer.append(i+1)
                    continue                    
        
            
        
    return answer