import heapq
t = int(raw_input())

for i in xrange(t):
    n,m = map(int, raw_input().split(' '))
    c = []
    cost = [[] for j in xrange(n)]
    min_cost = 0
    for j in xrange(n):
        cost[j] = map(int, raw_input().split(' '))
        cost[j].sort()
        for index in xrange(m):
            if index == 0:
                heapq.heappush(c, cost[j][index] + ((index+1) ** 2))
            else:
                heapq.heappush(c, cost[j][index] + ((index+1) ** 2) - (index ** 2))
        #print c
        min_cost += heapq.heappop(c)
    print 'Case #{0}: {1}'.format(i+1, min_cost)
