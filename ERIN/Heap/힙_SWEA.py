T = int(input())

answerSet = []
def removeMax(heap):
    global answerSet
    if len(heap) == 0:
        answerSet.append(-1)
    else:
        answerSet.append(heap[0])
        lastIdx = len(heap) - 1
        heap[0] = heap[lastIdx]
        heap.pop()
        heapify(heap, 0)


def insertVal(heap, val):
    heap.append(val)
    idx = len(heap)-1
    while idx >= 0:
        parentIdx = (idx-1)//2
        if parentIdx >= 0 and heap[parentIdx] < heap[idx]:
            heap[parentIdx], heap[idx] = heap[idx], heap[parentIdx]
            idx = parentIdx
        else:
            break

def heapify(heap, idx):
    leftIdx = idx*2+1
    rightIdx = idx*2+2
    maxIdx = idx

    if leftIdx <= len(heap)-1 and heap[maxIdx] < heap[leftIdx]:
        maxIdx = leftIdx
    if rightIdx <= len(heap)-1 and heap[maxIdx] < heap[rightIdx]:
        maxIdx = rightIdx
    if maxIdx != idx:
        heap[maxIdx], heap[idx] = heap[idx], heap[maxIdx]
        heapify(heap, maxIdx)

for test_case in range(1, T + 1):
    print("#{}".format(test_case), end='')
    N = int(input())
    heap = []
    answerSet = []
    for i in range(N):
        line = list(map(int, input().split()))
        if len(line) == 2:
            insertVal(heap, line[1])
        else:
            removeMax(heap)
    for n in answerSet:
        print("", n, end='')
    print()

