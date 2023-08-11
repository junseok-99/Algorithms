def solution(s):
    answer = True
    arr=[]
    if(s[0]==")" or len(s)==0):
        return False
    
    for i in s:
        if (i=="("):
            arr.append(i)
        else:
            if(len(arr)-1<0):
                return False
            if(arr.pop(len(arr)-1)=="("):
                continue
            else:
                return False
            
    if(len(arr)>0):
        answer=False

    return answer