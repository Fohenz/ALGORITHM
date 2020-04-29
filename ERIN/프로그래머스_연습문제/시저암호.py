def solution(s, n):
    answer = ''
    for c in s:
        if c.isupper():
            answer += chr((ord(c)- 65 + n) % 26 + 65)
        elif c.islower() :
            answer += chr((ord(c)- 97 + n) % 26 + 97)
        else:
            answer += c
    return answer
