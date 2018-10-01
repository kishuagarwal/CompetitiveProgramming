n, q = map(int, raw_input().split(' '))

nums = map(int, raw_input().split(' '))

for i in xrange(q):
    t, a, b = map(int, raw_input().split(' '))
    if t == 1:
        nums[a - 1] = b
    else:
        x = sorted(nums[a-1:b], reverse=True)
        if len(x) < 3:
            print(0)
            continue
        length = len(x)
        ans = 0
        for j in xrange(2, length):
            if x[j] + x[j-1] > x[j - 2]:
                ans = x[j] + x[j-1] + x[j - 2]
                break
        print(ans)
