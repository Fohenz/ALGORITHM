import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K:
        min1, min2 = heapq.heappop(scoville), heapq.heappop(scoville)
        scoville.append(min1+min2*2)
        answer += 1
        if len(scoville) == 1:
            if heapq.heappop(scoville) >= K:
                return answer
            else:
                return -1
    return answer
