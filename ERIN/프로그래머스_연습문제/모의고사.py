def solution(answers):
    answer = []
    num1 = [1, 2, 3, 4, 5]
    num2 = [2, 1, 2, 3, 2, 4, 2, 5]
    num3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    result = [[0, 1], [0, 2], [0, 3]]
    for i in range(len(answers)):
        if num1[i%5] == answers[i]:
            result[0][0] += 1
        if num2[i%8] == answers[i]:
            result[1][0] += 1
        if num3[i%10] == answers[i]:
            result[2][0] += 1
    score = max(result, key= lambda n: n[0])[0]
    for r in result:
        if r[0] == score:
            answer.append(r[1])
    answer.sort()
    return answer
