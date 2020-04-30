def solution(arrangement):
    answer, i = 0, 0
    stack = []
    while i < len(arrangement):
        a = arrangement[i]
        if a == '(':
            if arrangement[i+1] == ')':
                #레이저인경우
                answer += len(stack)
                i += 1
            else:
                stack.append(a)
        else:
            stack.pop()
            answer += 1         
        i += 1
    return answer
