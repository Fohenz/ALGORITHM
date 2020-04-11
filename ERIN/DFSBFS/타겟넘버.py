def solution(numbers, target):
    answer = 0
    answer += dfs(numbers, 0, target, -1)
    return answer

def dfs(numbers, total, target, i):
    if i == len(numbers)-1:
        if total == target :
            return 1
        else:
            return 0
    else:
        i += 1
        return dfs(numbers, total + numbers[i], target, i) + dfs(numbers, total - numbers[i], target, i)
