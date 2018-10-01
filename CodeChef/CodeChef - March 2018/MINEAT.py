import math

t = int(input())
ceil = math.ceil

for i in range(t):
    n, h = list(map(int, input().strip().split()))
    bananas = list(map(int, input().strip().split()))
    # Binary search on K
    low, high = 1, max(bananas)
    mid = low
    while low < high:
        # print('Before', low, high)
        mid = (low + high) // 2
        hours_required = 0
        for j in bananas:
            hours_required += ceil(j / mid)
        if hours_required <= h:
            high = mid
        elif hours_required > h:
            low = mid + 1
        # print('After', low, high)
    print(low)
