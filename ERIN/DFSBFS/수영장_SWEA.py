import sys


def dfs(fees, plans, month, money):
    global minFee
    if money > minFee:
        return minFee
    if month >= 12:
        minFee = min(money, minFee)
        return minFee
    else:
        #일
        d = dfs(fees, plans, month+1, money+ plans[month] * fees[0])
        #월
        m = dfs(fees, plans, month+1, money +fees[1])
        #3개월
        m3 = dfs(fees, plans, month+3, money + fees[2])
        return min(d, m, m3)


T = int(input())
minFee = 0

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    fees = list(map(int, input().split()))
    plans = list(map(int, input().split()))
    global minFee
    minFee = fees[-1]
    print("#{} {}".format(test_case, dfs(fees, plans, 0, 0)))

