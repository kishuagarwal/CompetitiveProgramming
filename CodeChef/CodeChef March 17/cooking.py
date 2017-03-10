import heapq
t = int(raw_input())
for i in xrange(t):
    n,k = map(int, raw_input().strip().split(' '))
    l = raw_input()
    counts = []
    left = []
    prev = l[0]
    count = 1
    ans = n
    index = -1
    for index,c in enumerate(l[1:]):
        if c == prev:
            count+=1
        else:
            heapq.heappush(counts, (-count, index-count+1, index))
            ans = max(ans, count)
            count = 1
            prev = c

    heapq.heappush(counts, (-count, index-count+2, index+1))
    j = 0
    while j < k:
        j += 1
        count, start,end = heapq.heappop(counts)
        count = -count
        if count == 1:
            heapq.heappush(counts, (-count,start,end))
            break
        if count == 2:
            if (start == 0 or end == n-1):
                heapq.heappush(counts, (-1, start, start))
                heapq.heappush(counts, (-1, end, end))
            else:
                heapq.heappush(left, (-count, start, end))
                j -= 1
                continue
        mid = (start + end) / 2
        end1 = mid-1
        start2 = mid+1
        count1 = -(end1-start+1)
        count2 = -(end-start2+1)
        heapq.heappush(counts, (count1, start, end1))
        heapq.heappush(counts, (-1, mid, mid))
        heapq.heappush(counts, (count2, start2, end)) 

    size = len(left)
    for _ in xrange(size):
        heapq.heappush(counts, heapq.heappop(left))
    ans = -(heapq.heappop(counts)[0])
    print ans 