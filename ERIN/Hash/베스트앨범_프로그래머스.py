from operator import itemgetter

def solution(genres, plays):
    answer = []
    num = 0
    dic, dic2 = {}, {}
    for g in genres:
        if g in dic.keys():
            dic[g].append((plays[num], num))
            dic2[g] += plays[num]
        else:
            dic[g] = [(plays[num], num)]
            dic2[g] = plays[num]
        num += 1
    lst = sorted(dic2.items(), key=itemgetter(1), reverse=True)
    
    for gen, _ in lst:
        val = dic[gen]
        val.sort(key=itemgetter(1))
        val.sort(key=itemgetter(0), reverse=True)
        for i in range(min(len(val), 2)):
            answer.append(val[i][1])

    return answer
