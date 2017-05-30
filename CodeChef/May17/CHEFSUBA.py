import heapq

n, k, p = map(int, raw_input().strip().split(' '))

l = map(int, raw_input().strip().split(' '))

q = raw_input()

k = min(k, n)

l += l[:k-1]

counts = []

one_counts = []
counts_count = [0 for i in xrange(n+1)]

def init():
    current_count = 0
    for i in xrange(k):
        current_count += l[i]
    heapq.heappush(counts,-current_count)
    counts_count[current_count] = 1
    one_counts.append(current_count)
    for i in xrange(k, n):
        current_count += l[i]
        current_count -= l[i-k]
        heapq.heappush(counts,-current_count)
        counts_count[current_count] += 1
        one_counts.append(current_count)
    for i in xrange(n, n+k-1):
        current_count += l[i]
        current_count -= l[i-k]
        one_counts.append(current_count)

init()

def find():
    while True:
        largest = -heapq.heappop(counts)
        if counts_count[largest] <= 0:
            continue
        print largest
        heapq.heappush(counts,-largest)
        break


current_l = 0
current_r = n - k 

for c in q:
    if c == '?':
        find()
    else:
        counts_count[one_counts[current_r]] -= 1

        current_r -= 1
        if current_r == -1:
            current_r = n  - 1
        current_l -= 1
        if current_l == -1:
            current_l = n  - 1
        heapq.heappush(counts,-one_counts[current_l])
        counts_count[one_counts[current_l]] += 1


