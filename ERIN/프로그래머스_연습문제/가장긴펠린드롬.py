def solution(s):
    answer = len(s)
    for i in reversed(range(len(s)+1)):
        for j in range(len(s)-i+1):
            if isPal(s[j:j+i]):
                return answer
        answer -= 1
    return answer

def isPal(s):
    result = True
    mid = (len(s))//2
    for i in range(mid):
        if s[i] == s[-i-1]:
            continue
        else:
            result = False
            break
            
    return result
