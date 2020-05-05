def solution(a, b):
    answer = ''
    months = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    days = ['THU', 'FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED']
    val = (sum(months[:a-1])+b)%7
    answer = days[val]
    return answer
