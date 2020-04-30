def solution(arrangement):
    answer = 0
    stack = []
    isFirst = True
    for p in arrangement:
        if p == ')':
            stack.pop()
            if isFirst:
                answer += len(stack)
            else:
                answer += 1
            isFirst = False
        else:
            stack += [p]
            isFirst = True
    return answer
