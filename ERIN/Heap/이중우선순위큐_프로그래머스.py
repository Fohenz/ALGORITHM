import heapq

maxHeap = []
minHeap = []

def solution(operations):
    for op in operations:
        alpha, val = op.split()
        val = int(val)
        if alpha == 'I':
            heapq.heappush(minHeap, val)
            heapq.heappush(maxHeap, (-val, val))
        elif alpha == 'D':
            if len(maxHeap) == 0:
                continue
            if val == 1:
                minHeap.remove(heapq.heappop(maxHeap)[1])
            elif val == -1:
                v = heapq.heappop(minHeap)
                maxHeap.remove((-v, v))
    
    if len(maxHeap) == 0:
        answer = [0, 0]
    else:
        answer = [maxHeap[0][1], minHeap[0]]
    return answer
