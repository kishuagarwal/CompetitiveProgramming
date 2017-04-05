n, c1,c2 = map(int, raw_input().strip().split(' '))
s = raw_input()
countA = 0
for c in s:
    if c == '1':
        countA += 1

ans = 1e18
for count in xrange(1,countA+1):
    p = n - count
    exact = p / count
    left = p % count
    temp = (count - left) * (c1 + c2 * exact * exact)
    temp += left * (c1 + c2 * (exact+1) * (exact+1))
    ans = min(ans, temp)

print ans 