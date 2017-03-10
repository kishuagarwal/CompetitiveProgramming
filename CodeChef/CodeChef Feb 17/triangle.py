n,l,r= map(int, raw_input().strip().split(' '))
s = map(int, raw_input().strip().split(' '))

s.sort()

ans = 0
cur_r = l - 1
ran = []
for i in xrange(1, n):
    lowest = s[i] + 1 - s[i-1]
    highest = s[i] + s[i-1] - 1
    lowest = max(lowest, l)
    highest = min(highest, r)
    if lowest <= highest:
        ran.append((lowest, highest))


ran.sort()
length = len(ran)
for index,(l,r) in enumerate(ran):
    if r > cur_r:
        ans += r - max(l, cur_r+1) + 1
        cur_r = r
print ans