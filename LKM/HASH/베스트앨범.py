def solution(genres, plays):
    answer = []
    d = {g:[] for g in genres}
    for i in range(len(genres)):
        g = genres[i]
        p = plays[i]
        d[g].append((i, p))
    gSort = sorted(d.keys(), key=lambda x: sum(map(lambda y: y[1], d[x])), reverse=True)

    for g in gSort:
        d[g] = sorted(d[g], key=lambda x: (x[1], -x[0]), reverse=True)
        answer += list(map(lambda x: x[0], d[g]))[:min(len(d[g]),2)]
    return answer
