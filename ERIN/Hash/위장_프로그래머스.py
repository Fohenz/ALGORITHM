def solution(clothes):
    answer = 1
    dic = {}
    for c in clothes:
        clothes, t = c
        if t in dic.keys():
            dic[t].append(clothes)
        else:
            dic[t] = [clothes]
    for k in dic.keys():
        answer *= len(dic[k])+1
    return answer-1
