from collections import deque

n, m, k = map(int, raw_input().strip().split())
b = map(int, raw_input().strip().split())

count = 0
cost = 0
dp = [10 ** 18 for i in xrange(n)]
pos = -1
locs = deque()
for i in xrange(1,n):
    if b[i]:
        if count == 0:
            cost += i 
        else:
            cost += (i - locs[-1]) * count * k 
        count += 1
        locs.append(i)
    if count == m:
        pos = i
        dp[i] = cost
        break

if pos != -1:
    for i in xrange(pos + 1, n):
        if b[i]:
            rightPos = locs[-1]
            leftPos = locs.popleft()
            cost -= (rightPos - leftPos) * k
            cost += (i - rightPos) * (m-1) * k
            if len(locs) > 0:
                cost += (locs[0] - leftPos)
            locs.append(i)
            dp[i] = cost

# print dp
if pos == -1:
    print -1
else:
    print min(dp) 
