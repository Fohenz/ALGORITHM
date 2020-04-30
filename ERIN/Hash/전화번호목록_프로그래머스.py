def solution(phone_book):
    answer = True
    l = 0
    dic = {}
    while True:
        for p in phone_book:
            pre = p[:l+1]
            val = p[l+1:]
            if pre in dic:
                dic[pre].append(val)
            else:
                dic[pre] = [val]
        if len(dic) == len(phone_book):
            return True
        else:
            l += 1
            for k in dic.values():
                for item in k:
                    if item == '' and len(k) > 1:
                        return False
            dic = {}
    return answer
