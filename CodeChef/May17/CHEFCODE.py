n, k = map(int, raw_input().strip().split())

l = map(int, raw_input().strip().split())

ans = 0

l.sort()
def calculate(pos, product):
    if pos < 0:
        return 0 
    if l[pos] > product:
        return 0
    ways = 1
    left = product / l[pos]
    temp = 1
    j = 0
    temp = 1
    for i in xrange(pos):
        temp *= l[i]
        if temp > k:
            j = i
            break
    ways += pow(2, j)
    for i in xrange(j,pos):
        ways += calculate(i, left)
    return ways
for i in xrange(n):
    ans += calculate(i, k)

print ans
