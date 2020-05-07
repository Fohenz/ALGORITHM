def solution(n, lost, reserve):
    answer = 0
    info = [1 for i in range(n)]
    for r in reserve:
        info[r-1] += 1
    for l in lost:
        info[l-1] -= 1
    if info[0] > 1 and info[1] == 0:
        info[0] -=1
        info[1] += 1
    if info[n-1] > 1 and info[n-2] == 0:
        info[n-1] -=1
        info[n-2] += 1
    for i in range(1, len(info)-1):
        if info[i] > 1:
            if info[i-1] == 0:
                info[i-1] += 1
                info[i] -= 1
            elif info[i+1] == 0:
                info[i+1] += 1
                info[i] -=1
    answer = n - info.count(0)
    return answer
