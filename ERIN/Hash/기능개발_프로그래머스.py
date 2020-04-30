def solution(progresses, speeds):
    answer = []
    while progresses != []:
        while progresses[0] >= 100:
            num = 0
            for i in range(len(progresses)):
                if progresses[0] >= 100:
                    num += 1
                    progresses.pop(0)
                    speeds.pop(0)
                else:
                    answer.append(num)
                    break    
                if progresses == []:
                    answer.append(num)
                    return answer
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
    return answer
