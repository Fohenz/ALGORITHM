def solution(bridge_length, weight, truck_weights):
    answer = 0
    crossing_list = []
    while len(truck_weights) > 0:
        if len(crossing_list) == bridge_length:
            crossing_list.pop(0)
        if weight >= sum(crossing_list) + truck_weights[0]:
            crossing_list.append(truck_weights[0])
            truck_weights.pop(0)
        else:
            crossing_list.append(0)
        answer += 1
    answer += bridge_length
    return answer
