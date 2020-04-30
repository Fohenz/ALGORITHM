import queue

def solution(bridge_length, weight, truck_weights):
    answer, total= 0, 0
    truck_while = queue.Queue() 

    while truck_weights != []:
        if truck_while.qsize() == bridge_length:
            total -= truck_while.get()
        if len(truck_weights) > 0 and total + truck_weights[0] <= weight:
            truck_while.put(truck_weights[0])
            total += truck_weights[0]
            truck_weights.pop(0) 
        else:
            truck_while.put(0)
        answer += 1
    answer += bridge_length
    return answer
