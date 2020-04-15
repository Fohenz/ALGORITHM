import heapq
def solution(stock, dates, supplies, k):
    answer = 0
    heap = []
    
    for i in range(len(dates)):
        heapq.heappush(heap, (-supplies[i], dates[i]))
    while stock < k:
        val = []
        while True:
            val.append(heapq.heappop(heap))
            if val[-1][1] <= stock:
                stock -= val[-1][0]
                for n in val[:-1]:
                    heapq.heappush(heap, n)
                answer+=1
                break
    return answer
