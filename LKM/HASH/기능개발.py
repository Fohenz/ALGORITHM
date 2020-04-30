import math
def solution(progresses, speeds):
    answer = []
    times = [math.ceil((100 - p) / s) for p, s in zip(progresses, speeds)]
    while len(times) > 0:
        count = 1
        top = times.pop(0)
        while len(times) > 0:
            if times[0] <= top:
                times.pop(0)
                count += 1
            else:
                break
        answer += [count]
    return answer
