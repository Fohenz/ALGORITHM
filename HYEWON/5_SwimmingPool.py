import sys
sys.stdin = open("C:/Users/user/Desktop/sample_input.txt", "r")

T = int(input())

def dfs(month, price):
    global min_price # 막 선언 해도 돼?
    if month > 11:
        if min_price > price:
            min_price = price
        return
    
    if plan_list[month] == 0:
        dfs(month+1,price)
    else:
        # 1일
        dfs(month+1,price+plan_list[month]*price_list[0])
        # 1달
        dfs(month+1,price+price_list[1])
        # 3달
        dfs(month+3,price+price_list[2])
    
for test_case in range(1, T + 1):
    price_list = list(map(int,input().split()))
    plan_list = list(map(int,input().split()))
    min_price = price_list[3]
    dfs(0,0) #dfs 함수가 무조건 위에 있어야해?
    print('#{} {}'.format(test_case,min_price))
