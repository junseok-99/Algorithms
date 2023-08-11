def solution(nums):
    answer = 0
    get_sum=len(nums)/2
    poke_set=set(nums)
    
    if (get_sum<len(poke_set)):
        while(get_sum!=len(poke_set)):
            poke_set.pop()
            answer=len(poke_set)
    else:
        answer=len(poke_set)
        
    
        
    
    return answer