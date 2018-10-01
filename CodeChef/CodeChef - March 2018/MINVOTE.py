import sys
t = int(raw_input())


for i in xrange(t):
    n = int(raw_input())
    influence = list(map(int, raw_input().strip().split()))

    for j in xrange(1, n):
        influence[j] += influence[j - 1]

    ans = [0 for _ in xrange(n)]

    for j in xrange(n):
        if j == 0:
            cur_inf = influence[0]
        else:
            cur_inf = influence[j] - influence[j - 1]
        # binary search on left
        # Find point on the left till where sum is less than or equal to cur_inf. May be equal to j
        if j > 0:
            pivot = None
            low, high = 1, j
            while low < high:
                # print(low, high)
                mid = (low + high) // 2
                current_sum = influence[j] - cur_inf - influence[mid - 1]
                if current_sum <= cur_inf:
                    high = mid
                else:
                    low = mid + 1
            pivot = low
            for k in xrange(pivot - 1, j):
                ans[k] += 1

        # binary search on right
        # Find point on the right till where sum is less than or equal to cur_inf. May be equal to j
        if j < n - 1:
            pivot = None
            low, high = j, n - 2
            while low < high:
                # print(low, high)
                mid = (low + high) // 2
                current_sum = influence[mid] - influence[j]
                if current_sum <= cur_inf:
                    low = mid
                    if high == low + 1:
                        current_sum = influence[high] - influence[j]
                        if current_sum <= cur_inf:
                            pivot = high
                            break
                        pivot = low
                        break
                else:
                    high = mid - 1
            else:
                pivot = low

            for k in xrange(j + 1, pivot + 2):
                ans[k] += 1
    ans = map(str, ans)
    sys.stdout.write(' '.join(ans))
    sys.stdout.write('\n')

