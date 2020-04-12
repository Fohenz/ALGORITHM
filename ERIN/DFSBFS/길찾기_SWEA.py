def dfs(dic, cur):
    if cur == 99:
        return 1
    
    if cur == -1:
        return 0

    else:
        val1, val2 = 0, 0
        next1, next2 = dic[cur]
        if next1 != -1:
            val1 = dfs(dic, next1)
        if next2 != -1:
            val2 = dfs(dic, next2)
        return max(val1, val2)

T = 10

for test_case in range(1, T + 1):
    _, n = map(int, input().split())
    dic = [[-1,-1] for i in range(100)]
    inputList = list(map(int, input().split()))
    for i in range(n):
        idx, val = inputList[2*i], inputList[2*i+1]
        if dic[idx][0] == -1:
           dic[idx][0] = val
        else:
            dic[idx][1] = val
    print("#{} {}".format(test_case, dfs(dic, 0)))
        


