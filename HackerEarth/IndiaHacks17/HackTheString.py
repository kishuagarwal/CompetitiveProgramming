n = int(raw_input().strip())
l = map(int, raw_input().strip().split())

ones = l.count(1)

counts = []

count = 0

for i in l:
    if i == 0:
        if count > 0:
            counts.append(count)
            count = 0
        counts.append(0)
    else:
        count += 1

if count > 0:
    counts.append(count)

length = len(counts)
ans = 0
n = counts

for i in xrange(length):
    if n[i] == 0 and i > 0:
        if n[i-1] > 0 and i+1 < length and n[i+1] > 0 and ones > n[i-1] + n[i+1]:
            ans = max(ans, n[i-1] + n[i+1] + 1)
        elif n[i-1] > 0 and ones > n[i-1]:
            ans = max(ans, n[i-1] + 1)
        elif i + 1 < length and n[i+1] > 0 and ones > n[i+1]:
            ans = max(ans, n[i+1] + 1)
    else:
        ans = max(ans, n[i])

print ans   