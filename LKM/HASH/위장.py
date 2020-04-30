def solution(clothes):
    answer = 0
    
    d = {}
    for c, t in clothes:
        d[t] = (d[t] + 1 if t in d else 1)

    s = 1
    for k, v in d.items():
        s *= v+1
    answer = s - 1
    return answer
