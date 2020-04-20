def solution(N, number):
    answer = -1
    matrix = [ set() for a in range(9)]
    matrix[0].add(N)
    for i in range(len(matrix)-1):
        numbers = matrix[i]
        for k in range(i+1):
            matrix[i+1].add(int(str(N)*(k+2)))
        if number in numbers:
            return i+1
        j = 0
        while i+j < 8:
            nums1, nums2 = matrix[i], matrix[j]
            for n1 in nums1:
                for n2 in nums2:
                    matrix[i+j+1].add(n1+n2)
                    matrix[i+j+1].add(n1*n2)
                    if n1 - n2 >= 0:
                        matrix[i+j+1].add(n1-n2)
                    else:
                        matrix[i+j+1].add(n2-n1)
                    if n2 != 0:
                        matrix[i+j+1].add(n1//n2)
                    if n1 != 0:
                        matrix[i+j+1].add(n2//n1)
            j += 1

    return answer
