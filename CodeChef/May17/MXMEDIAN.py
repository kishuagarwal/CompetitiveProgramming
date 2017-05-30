t = int(raw_input())

for i in xrange(t):
    n = int(raw_input())
    nums = map(int, raw_input().strip().split(' '))
    nums.sort()
    print nums[-(n/2 + 1)]
    for j in xrange(n):
        print nums[j],nums[n + j],